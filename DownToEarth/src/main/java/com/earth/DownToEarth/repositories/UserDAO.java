package com.earth.DownToEarth.repositories;

import com.earth.DownToEarth.models.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUser();
    User getOneUser(Integer userId);
    Integer createUser(User user);
    void updateUser(User user);
    void deleteUser(User user);

    User getOneUserByUsername(String username);
}
