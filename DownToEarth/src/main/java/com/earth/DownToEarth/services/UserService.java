package com.earth.DownToEarth.services;

import com.earth.DownToEarth.models.User;
<<<<<<< HEAD
import com.earth.DownToEarth.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
=======
import com.earth.DownToEarth.repositories.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
>>>>>>> 99742ad7e2cbb88404d80854f7480aa8e0031860

@Service
@Transactional
public class UserService {
<<<<<<< HEAD
    private UserRepo userRepo;

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public UserService(UserRepo userRepo) { this.userRepo= userRepo;}

    public User createUser(User user) {
        String encodedPassword = this.passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        Integer userId = this.userRepo.createUser(user);
        return this.userRepo.getOneUser(userId);
    }

    public User getUserById(Integer userId) {return this.userRepo.getOneUser(userId);}
=======

    @Autowired //field injection not recommended
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
>>>>>>> 99742ad7e2cbb88404d80854f7480aa8e0031860
}
