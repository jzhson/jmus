package com.tronxincloud.bmobtest.bmob.present;

import android.util.Log;

import com.tronxincloud.bmobtest.bean.UserBean;
import com.tronxincloud.bmobtest.bmob.model.UserRegisterModelImp;
import com.tronxincloud.bmobtest.bmob.view.UserRegisterView;
import com.tronxincloud.bmobtest.custominterface.RegisterUserInf;

/**
 * Created by Jzhson Davis on 8/6/2018.
 */

public class UserRegisterPresentImp implements UserRegisterPresent {
    private UserRegisterView userRegisterView;
    private UserRegisterModelImp userRegisterModelImp;

    public UserRegisterPresentImp(UserRegisterView userRegisterView) {
        this.userRegisterView = userRegisterView;
        userRegisterModelImp =new UserRegisterModelImp();
    }

    @Override
    public void checkUsername(String username) {
        userRegisterModelImp.checkUserExist(username);
        userRegisterModelImp.setOncheckUserExistResult(new RegisterUserInf.checkUserExist() {
            @Override
            public void done(boolean has) {

                if (has){
                    userRegisterView.showUserExist("您输入的用户名已经存在，请重新输入。");
                }

                else{
                    userRegisterView.showUserExist("您输入的用户名可以使用哦");
                }


            }

            @Override
            public void error(int errorcode, String message) {

            }
        });

    }

    @Override
    public void checkDevice(String deviceId) {

    }

    @Override
    public void regist(UserBean userBean) {
        userRegisterModelImp.registUser(userBean);
        userRegisterModelImp.setOnRegisterUserResult(new RegisterUserInf.registerUser() {
            @Override
            public void success() {
                userRegisterView.showUserExist("注册成功！");
            }

            @Override
            public void error(int errorcode, String message) {
                userRegisterView.showUserExist(message+"!错误代码："+errorcode);
            }
        });
    }
}
