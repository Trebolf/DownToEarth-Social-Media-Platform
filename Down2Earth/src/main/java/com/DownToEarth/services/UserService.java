package com.DownToEarth.services;

import com.DownToEarth.models.User;
import com.DownToEarth.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {

    private UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    public User createUser(User user){
        Integer userId = this.userRepo.createUser(user);
        return this.userRepo.getOneUser(userId);
    }

    public List<User> getAllUsers(){
        return this.userRepo.findAll();
    }

    public User getOne(Integer userId){
        return this.userRepo.getOneUser(userId);
    }
}
