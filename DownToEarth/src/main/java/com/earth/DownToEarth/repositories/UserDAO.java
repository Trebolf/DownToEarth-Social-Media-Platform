package com.earth.DownToEarth.repositories;

import com.earth.DownToEarth.models.User;

import java.util.List;

public interface UserDAO {
    User getOneUser(Integer userId);
    void updateUser(User user);
    void deleteUser(User user);
    User getOneUserByUsername(String username);
}
