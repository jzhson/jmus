package com.tronxincloud.bmobtest.bmob.present;

import com.tronxincloud.bmobtest.bean.UserBean;

/**
 * Created by Jzhson Davis on 8/6/2018.
 */

public interface UserRegisterPresent {
    void checkUsername(String username);
    void checkDevice(String deviceId);
    void regist(UserBean userBean);
}
