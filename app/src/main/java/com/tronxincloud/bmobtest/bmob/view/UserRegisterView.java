package com.tronxincloud.bmobtest.bmob.view;

/**
 * Created by Jzhson Davis on 8/5/2018.
 */

public interface UserRegisterView {
    void showRegisterProgress(String message);
    void hideRegisterProgress();
    void showUserExist(String message);
    void shoeRegisterSuccessDialog(String message);
    void showNetError();
    void showFailedAlertDialog(String message);
    void hideFaildeAlerDialog();
    void showInvalidateData(String message);

}
