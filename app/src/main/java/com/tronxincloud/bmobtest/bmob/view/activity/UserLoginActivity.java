package com.tronxincloud.bmobtest.bmob.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tronxincloud.bmobtest.R;
import com.tronxincloud.bmobtest.bmob.present.UserLoginPresentImp;
import com.tronxincloud.bmobtest.bmob.view.UserLoginView;
import com.tronxincloud.bmobtest.utils.ActivityUtils;
import com.tronxincloud.bmobtest.utils.DialogUtils;
import com.tronxincloud.bmobtest.utils.ToastUtils;

import cn.bmob.v3.Bmob;

/**
 * Created by Administrator on 2018/8/2.
 */

public class UserLoginActivity extends AppCompatActivity implements UserLoginView,View.OnClickListener {
    private EditText input_username;
    private EditText input_password;
    private ImageView img_password_visibility;
    private CheckBox cbox_rememberUser;
    private CheckBox cbox_autoLogin;
    private TextView tv_forgetPassword;
    private Button btn_login;
    private Button btn_register;
    private UserLoginPresentImp bmobUserLoginPresentImp;
    private boolean bl_passwordVisility=false;
    private DialogUtils dialogUtils;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmob_userlogin);
        Bmob.initialize(this,"97ac29e899bd2088013f17aa93b9815a");
        dialogUtils=new DialogUtils();
        initView();
    }

    private void initView() {
        input_username = (EditText) findViewById(R.id.input_username);
        input_password = (EditText) findViewById(R.id.input_password);
        img_password_visibility = (ImageView) findViewById(R.id.img_password_visibility);
        img_password_visibility.setOnClickListener(this);
        cbox_rememberUser = (CheckBox) findViewById(R.id.cbox_rememberUser);
        cbox_autoLogin = (CheckBox) findViewById(R.id.cbox_autoLogin);
        tv_forgetPassword = (TextView) findViewById(R.id.tv_forgetPassword);
        tv_forgetPassword.setOnClickListener(this);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_register = (Button) findViewById(R.id.btn_register);
        btn_login.setOnClickListener(this);
        btn_register.setOnClickListener(this);
        bmobUserLoginPresentImp=new UserLoginPresentImp(this,this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                submit();
                break;
            case R.id.btn_register:
                ActivityUtils.toActivity(this,UserRegisterActivity.class);
                break;
            case R.id.img_password_visibility:
                passwordVisibiltySet(bl_passwordVisility);
                break;
            case R.id.tv_forgetPassword:
                bmobUserLoginPresentImp.forgotPassword(dialogUtils);
                break;
        }
    }

    private void submit() {
        // validate
        String username = input_username.getText().toString().trim();
        if (TextUtils.isEmpty(username)) {
            Toast.makeText(this, "用户名", Toast.LENGTH_SHORT).show();
            return;
        }

        String password = input_password.getText().toString().trim();
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "密码", Toast.LENGTH_SHORT).show();
            return;
        }
        bmobUserLoginPresentImp.loginToServer(getUsername(),getPassword());
    }

    @Override
    public void showLoginProgress(String message) {
        DialogUtils.showLoadingProgressDialog(this,message,false);
    }

    @Override
    public void hideLoginProgress() {
        DialogUtils.hideLoadingProgressDialog(this);
    }

    @Override
    public void showLoginError() {
        clearPassword();
        ToastUtils.kTd(this,"登陆失败",ToastUtils.KT_ERROR);
    }

    @Override
    public void showLoginSuccess() {
        ToastUtils.kTd(this,"登陆成功啦！~_~",ToastUtils.KT_SUCCESS);
    }


    @Override
    public String getUsername() {
        return input_username.getText().toString();
    }

    @Override
    public String getPassword() {
        return input_password.getText().toString();
    }

    @Override
    public void setRememberStatus(String username, String password, Boolean isRememberUser, Boolean isAutoLogin) {

    }

    @Override
    public void clearPassword() {
        input_password.setText("");
    }

    @Override
    public void passwordVisibiltySet(Boolean isVisible) {
        if (isVisible){
//            input_password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            input_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
            bl_passwordVisility=false;
            img_password_visibility.setImageResource(R.mipmap.ic_password_visible_48);
        }
        else{

//            input_password.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);  方法一
            input_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            bl_passwordVisility=true;
            img_password_visibility.setImageResource(R.mipmap.ic_password_invisible_48);
        }

        if (!input_password.getText().toString().equals("")){
            input_password.setSelection(input_password.getText().toString().length()); // 执行光标定位到最后一个
        }
    }

    @Override
    public void showForgetPassword() {
        dialogUtils.showForgetPasswordDialog(this,true);
    }

    @Override
    public void hideForgetPassword() {
        dialogUtils.hideForgetPasswordDialog(this);
    }

    @Override
    public void onBackPressed() {

    }
}
