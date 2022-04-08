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
    }

    @Test
    void getOne() {
    }

    @Test
    void updateOne() {
    }

    @Test
    void deleteOne() {
    }

    @Test
    void getOneUserByUsername() {
    }
}