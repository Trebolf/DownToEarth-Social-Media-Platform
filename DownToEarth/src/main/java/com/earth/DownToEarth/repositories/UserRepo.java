package com.earth.DownToEarth.repositories; /**When doing research, I initially used Spring Data, but had to
 change it back this morning! OOPS!!!**/

import com.earth.DownToEarth.models.User;

public interface UserRepo {
    Integer createUser(User user);
    User getOneUser(Integer userId);

}