package com.tronxincloud.bmobtest.bmob.model;

import com.tronxincloud.bmobtest.bean.UserBean;
import com.tronxincloud.bmobtest.custominterface.OnLoginResult;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by Jzhson Davis on 8/2/2018.
 */

public class UserLoginModelImp implements UserLoginModel {
    private boolean resultStaus;
    @Override
    public UserBean getUserInfo(String username) {
        return null;
    }

    @Override
    public void doLogin(String username,String password) {
        UserBean userBean=new UserBean();
        userBean.setUsername(username);
        userBean.setPassword(password);
        userBean.login(new SaveListener<UserBean>() {
            @Override
            public void done(UserBean user, BmobException e) {
                if (onLoginResultListener!=null){
                    onLoginResultListener.onLoginResult(e);
                }
            }
        });
    }

    public void setOnLoginResultListener(OnLoginResult onLoginResultListener) {
        this.onLoginResultListener = onLoginResultListener;
    }

    private OnLoginResult onLoginResultListener;

}
