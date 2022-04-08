package com.revature.D2E.repos;

import com.revature.D2E.models.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();
    User getOneUser(Integer userId);
    Integer createUser(User user);
    void updateUser(User user);
    void deleteUser(User user);

    User getOneUserByUsername(String username);
}
