package com.DownToEarth.repos; /**When doing research, I initially used Spring Data, but had to
 change it back this morning! OOPS!!!**/

import com.DownToEarth.models.User;

import java.util.List;

public interface UserRepo {
    Integer createUser(User user);
    List<User> findAll();
    User getOneUser(Integer userId);

}
