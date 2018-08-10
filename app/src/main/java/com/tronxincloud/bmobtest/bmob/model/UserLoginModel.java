package com.tronxincloud.bmobtest.bmob.model;

import com.tronxincloud.bmobtest.bean.UserBean;

/**
 * Created by Jzhson Davis on 8/2/2018.
 */

public interface UserLoginModel {
    UserBean getUserInfo(String username);
    void doLogin(String username,String password);

}
