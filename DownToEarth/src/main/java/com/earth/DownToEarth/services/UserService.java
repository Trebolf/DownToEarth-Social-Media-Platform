package com.earth.DownToEarth.services;

import com.earth.DownToEarth.models.User;
import com.earth.DownToEarth.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {
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
}
