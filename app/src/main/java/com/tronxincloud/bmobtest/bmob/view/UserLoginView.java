package com.tronxincloud.bmobtest.bmob.view;

import android.content.Context;

/**
 * Created by Administrator on 2018/8/2.
 */

public interface UserLoginView {
    void showLoginProgress(String message);
    void hideLoginProgress();
    void showLoginError();
    void showLoginSuccess();
    String getUsername();
    String getPassword();
    void setRememberStatus(String username,String password,Boolean isRememberUser,Boolean isAutoLogin);
    void clearPassword();
    void passwordVisibiltySet(Boolean isVisible);
    void showForgetPassword();
    void hideForgetPassword();
}
