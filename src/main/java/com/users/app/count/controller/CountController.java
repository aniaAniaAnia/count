package com.users.app.count.controller;

import com.users.app.count.domain.UserData;
import com.users.app.count.exception.CannotCreateUserJsonException;
import com.users.app.count.repository.UserRepository;
import com.users.app.count.service.UserService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CountController {
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/users/{id}")
    @ResponseBody
    public ResponseEntity<String> geUserDataResponse(@PathVariable String id) {
        userRepository.save(getUserDataByIdOrCreateNewOne(id));
            return userService.getUserDataJsonResponse(id);
    }

    @GetMapping("/find/{id}")
    @ResponseBody
    public String geUserFromDB(@PathVariable @NonNull String id) {
        return userRepository.findById(id).stream().findFirst()
                .map(user -> String.valueOf(user.getRequestCount())).orElse("Does NotExist");
    }

    private UserData getUserDataByIdOrCreateNewOne(String id) {
        return userRepository.findById(id).map(userData -> {
            userData.setRequestCount(userData.getRequestCount() + 1);
            return userData;
        }).orElse(new UserData(id, 1));
    }
}
