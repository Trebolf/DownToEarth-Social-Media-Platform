package com.revature.D2E.services;

import com.revature.D2E.models.User;
import com.revature.D2E.repos.UserDAO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    private UserService userService;
    private UserDAO userDAO = Mockito.mock(UserDAO.class);

     public UserServiceTest() {
         userService = new UserService(userDAO);
     }

    @Test
    void getAllUsers() {
        //arrange
        List<User> expectedList = new ArrayList<>();
        expectedList.add(new User(
                1,
                "email",
                "username",
                "password",
                "firstname",
                "lastname",
                "location"
                ));
        expectedList.add(new User(
                2,
                "email",
                "username",
                "password",
                "firstname",
                "lastname",
                "location"));
        Mockito.when(userDAO.getAllUsers()).thenReturn(expectedList);

        List<User> actualList = userService.getAllUsers();

        assertEquals(expectedList, actualList);
        System.out.println("Result of getting all Users: " + expectedList);
    }

    @Test
    void createUser() {
         User user = new User(
                 1,
                 "email",
                 "username",
                 "password",
                 "firstname",
                 "lastname",
                 "location");

         userService.createUser(user);

         Mockito.verify(userDAO, Mockito.times(1)).createUser(user);
    }



    @Test
    void getOne() {
         Integer userId = 1;

         userService.getOne(userId);

         Mockito.verify(userDAO, Mockito.times(1)).getOneUser(userId);
    }

    @Test
    void updateOne() {
        User user = new User(
                1,
                "email",
                "username",
                "password",
                "firstname",
                "lastname",
                "location");

        userService.updateOne(user);

        Mockito.verify(userDAO, Mockito.times(1)).getOneUser(user.getUserId());
    }

    @Test
    void deleteOne() {
        User user = new User(
                1,
                "email",
                "username",
                "password",
                "firstname",
                "lastname",
                "location");

        userService.deleteOne(user.getUserId());

        Mockito.verify(userDAO, Mockito.times(1)).deleteUser(user);
    }

    @Test
    void getOneUserByUsername() {
        User expectedOutput = new User(
                1,
                "email",
                "username",
                "password",
                "firstname",
                "lastname",
                "location"
        );
        Mockito.when(userDAO.getOneUserByUsername(expectedOutput.getUsername())).thenReturn(expectedOutput);

        User actualOutput = userService.getOneUserByUsername(expectedOutput.getUsername());

        assertEquals(expectedOutput, actualOutput);
    }
}