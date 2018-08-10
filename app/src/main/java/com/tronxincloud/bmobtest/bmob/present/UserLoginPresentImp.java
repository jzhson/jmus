package com.tronxincloud.bmobtest.bmob.present;




import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import com.tronxincloud.bmobtest.bmob.model.UserLoginModelImp;
import com.tronxincloud.bmobtest.bmob.view.UserLoginView;
import com.tronxincloud.bmobtest.custominterface.ForgetPassowordInf;
import com.tronxincloud.bmobtest.custominterface.OnLoginResult;
import com.tronxincloud.bmobtest.utils.DialogUtils;


import cn.bmob.v3.exception.BmobException;


/**
 * Created by Jzhson Davis on 8/3/2018.
 */

public class UserLoginPresentImp implements UserLoginPresent {
    private UserLoginView bmobUserLoginView;
    private UserLoginModelImp bmobUserLoginModelImp;
    private Handler mHandler;
    private Context context;
    public UserLoginPresentImp(Context context, UserLoginView bmobUserLoginView) {
        this.bmobUserLoginView=bmobUserLoginView;
        this.context=context;
        this.bmobUserLoginModelImp=new UserLoginModelImp();
        mHandler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

            }
        };
    }

    @Override
    public void loginToServer(final String username, final String password) {
        bmobUserLoginView.showLoginProgress("正在登录");
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                bmobUserLoginModelImp.doLogin(username,password);
            }
        },3000);
        bmobUserLoginModelImp.setOnLoginResultListener(new OnLoginResult() {
            @Override
            public void onLoginResult(BmobException e) {
                bmobUserLoginView.hideLoginProgress();
                if (e==null){
                    loginSuccess();
                }
                else{
                    loginFailed();
                }
            }
        });
    }



    @Override
    public void loginFailed() {
        bmobUserLoginView.showLoginError();
    }

    @Override
    public void loginSuccess() {
        bmobUserLoginView.showLoginSuccess();
    }

    @Override
    public void forgotPassword(DialogUtils dialogUtils) {
        bmobUserLoginView.showForgetPassword();
        dialogUtils.clickOnFindpwdByPhone(new ForgetPassowordInf.FindpwdByPhone() {
            @Override
            public void doFind() {
                Toast.makeText(context,"您点击了通过手机找回密码",Toast.LENGTH_LONG).show();
            }
        });

        dialogUtils.clickOnFindpwdBySecurityQuestion(new ForgetPassowordInf.FindpwdBySecurityQuestion() {
            @Override
            public void doFind() {
                Toast.makeText(context,"您点击了通过安全问题密码",Toast.LENGTH_LONG).show();
            }
        });

        dialogUtils.clickOnFindpwdByVerifyEmail(new ForgetPassowordInf.FindpwdByVerifyEmail() {
            @Override
            public void doFind() {
                Toast.makeText(context,"您点击了通过邮箱找回密码",Toast.LENGTH_LONG).show();
            }
        });

        dialogUtils.clickOnFindpwdByWorkdtuff(new ForgetPassowordInf.FindpwdByWorkdtuff() {
            @Override
            public void doFind() {
                Toast.makeText(context,"您点击了通过人工找回密码",Toast.LENGTH_LONG).show();
            }
        });
    }

}
