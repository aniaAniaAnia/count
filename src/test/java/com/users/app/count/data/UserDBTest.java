package com.users.app.count.data;

import com.users.app.count.domain.UserData;
import com.users.app.count.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserDBTest {

        @InjectMocks
        private UserDB dbService;

        @Mock
        private UserRepository taskRepository;

    @Test
    public void testGetUserDataById() {
        UserData userData1 = new UserData("mk", 9);
        UserData userData2 = new UserData( "title", 26565);
        List<UserData> userDataList = new ArrayList<>();
        userDataList.add(userData1);
        userDataList.add(userData2);

        when(dbService.getUserData("mk")).thenReturn(Optional.ofNullable(userData1));
        when(dbService.getUserData("title")).thenReturn(Optional.ofNullable(userData2));

        Optional<UserData> userDatas = dbService.getUserData("mk");
        assertEquals(userData1.getId(), userDatas.get().getId());
    }

    @Test
    public void testSaveUserData() {
        UserData userData1 = new UserData("test", 785);
        when(dbService.save(userData1)).thenReturn(userData1);

        UserData userDataTest = dbService.save(userData1);

        assertEquals(userData1.getId(), userDataTest.getId());
        assertEquals(userData1.getRequestCount(), userDataTest.getRequestCount());
    }
}
