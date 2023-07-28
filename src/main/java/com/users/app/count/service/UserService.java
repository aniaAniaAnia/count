package com.users.app.count.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.users.app.count.exception.CannotCreateUserJsonException;
import com.users.app.count.user.UserJson;
import com.users.app.count.user.UserJsonResp;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.NoSuchElementException;

@Service
@Repository
public class UserService {

    String apiUrl = "https://api.github.com/users/" ;

    public ResponseEntity<String> getUserDataJsonResponse(String id) {

        UserJson userJson = fetchUserJsonFromApi(id);
        return ResponseEntity.ok(new GsonBuilder().setPrettyPrinting().create().toJson(new UserJsonResp(userJson)));
    }

    private UserJson fetchUserJsonFromApi(String id) {
        WebClient webClient = WebClient.create(apiUrl);

        return webClient.get()
                .uri(id)
                .retrieve()
                .bodyToMono(UserJson.class)
                .block();
    }
}
