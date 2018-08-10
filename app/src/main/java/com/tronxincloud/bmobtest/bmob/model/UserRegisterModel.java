package com.tronxincloud.bmobtest.bmob.model;

import com.tronxincloud.bmobtest.bean.UserBean;

/**
 * Created by Jzhson Davis on 8/6/2018.
 */

public interface UserRegisterModel {
    void registUser(UserBean userBean);
    void checkUserExist(String username);
    void checkDevice(String deviceSN);
}
