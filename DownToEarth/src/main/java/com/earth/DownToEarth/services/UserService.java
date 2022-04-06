package com.earth.DownToEarth.services;

import com.earth.DownToEarth.models.User;
import com.earth.DownToEarth.repositories.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public User getOne(Integer userId) {
        return userDAO.getOneUser(userId);
    }

    public User updateOne(User user) {
        userDAO.updateUser(user);

        return userDAO.getOneUser(user.getUserId());
    }

    public void deleteOne(Integer userId) {
        User user = userDAO.getOneUser(userId);

        userDAO.deleteUser(user);
    }

    public User getOneUserByUsername(String username) {
        return userDAO.getOneUserByUsername(username);
    }
}
