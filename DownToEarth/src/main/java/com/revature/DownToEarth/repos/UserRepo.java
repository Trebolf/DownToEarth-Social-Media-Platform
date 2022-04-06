package com.revature.DownToEarth.repos; /**When doing research, I initially used Spring Data, but had to
 change it back this morning! OOPS!!!**/

import com.revature.DownToEarth.models.User;

import java.util.List;

public interface UserRepo {
    Integer createUser(User user);
    User getOneUser(Integer userId);

}