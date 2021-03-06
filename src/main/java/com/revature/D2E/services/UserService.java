package com.revature.D2E.services;

import com.amazonaws.services.ec2.model.UserData;
import com.revature.D2E.models.User;
import com.revature.D2E.repos.UserDAO;
import com.revature.D2E.repos.UserDAOImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

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

    public User validateCredentials(String username, String password){
        User user = userDAO.getOneUserByUsername(username);

        if(user == null)
            return null;

        if(!password.equals(user.getPassword()))
            return null;

        return user;
    }

    public User getOneUserByUsername(String username) {
        return userDAO.getOneUserByUsername(username);
    }
}
