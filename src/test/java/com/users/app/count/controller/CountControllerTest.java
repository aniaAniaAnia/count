package com.users.app.count.controller;

import com.users.app.count.domain.UserData;
import com.users.app.count.repository.UserRepository;
import com.users.app.count.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CountControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private CountController countController;

    @Mock
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(countController).build();
    }

    @Test
    public void testUser() throws Exception {
        // Given
        String id = "octocat";
        UserData userData = new UserData(id, 1);

        when(userRepository.findById(id)).thenReturn(Optional.of(userData));

        String responseJson = "{\"id\":\"...\",\"login\":\"...\",\"name\":\"...\"}"; // Mock JSON response
        when(userService.getUserDataJsonResponse(id)).thenReturn(ResponseEntity.ok(responseJson));

        mockMvc.perform(MockMvcRequestBuilders.get("/users/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(responseJson));

        verify(userRepository).save(Mockito.any(UserData.class));
    }
}