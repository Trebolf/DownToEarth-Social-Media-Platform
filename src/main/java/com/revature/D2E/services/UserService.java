package com.revature.D2E.services;

import com.revature.D2E.models.User;
import com.revature.D2E.repos.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    public User createUser(User user) {
        Integer userId = userDAO.createUser(user);
        return userDAO.getOneUser(userId);
    }

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
