package com.tronxincloud.bmobtest.bmob.present;

import com.tronxincloud.bmobtest.utils.DialogUtils;

/**
 * Created by Jzhson Davis on 8/3/2018.
 */

public interface UserLoginPresent {
    void loginToServer(String username,String password);
    void loginFailed();
    void loginSuccess();
    void forgotPassword(DialogUtils dialogUtils);
}
