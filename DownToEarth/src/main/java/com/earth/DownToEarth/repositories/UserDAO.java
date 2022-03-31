package com.earth.DownToEarth.repositories;

import com.earth.DownToEarth.models.User;

public interface UserDAO {
    void createUser (User user);
    void updateInfo (Integer userId);
}
