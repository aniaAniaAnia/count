package com.users.app.count.data;

import com.users.app.count.domain.UserData;
import com.users.app.count.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDB {
        @Autowired
        private UserRepository repository;

        public UserData save(final UserData userData){
            return repository.save(userData);
        }

        public Optional<UserData> getUserData(final String id){
            return repository.findById(id);
        }

}
