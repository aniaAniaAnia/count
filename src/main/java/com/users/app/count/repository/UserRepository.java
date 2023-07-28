package com.users.app.count.repository;

import com.users.app.count.domain.UserData;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserData, String> {

        @Override
        UserData save(UserData userData);

        @Override
        Optional<UserData> findById(String id);

}
