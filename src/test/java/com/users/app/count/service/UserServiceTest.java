package com.users.app.count.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Test
    public void testGetUserDataJsonResponse() {
        String id = "octocat";

        ResponseEntity<String> jsonResponse = userService.getUserDataJsonResponse(id);

        assertNotNull(jsonResponse);

    }
}