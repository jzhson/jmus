package com.tronxincloud.bmobtest.utils;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.hss01248.roundprogressbar.SmoothRoundProgressBar;
import com.tronxincloud.bmobtest.R;
import com.tronxincloud.bmobtest.custominterface.ForgetPassowordInf;

/**
 * Created by Jzhson Davis on 8/3/2018.
 */

public class DialogUtils {
    public static Dialog dialogLodingProgress;
    public static Dialog dialogForgetPassword;



    /*-----------------------------------------------这里显示用于提示用户等待的Dialog-------------------------------------------------------------*/

    /**
     * 用来显示等待中的Dialog。可以自定义显示要提示的文字
     */
    public static void showLoadingProgressDialog(Context context, String message, Boolean isCancelable) {
        dialogLodingProgress = new Dialog(context);
        dialogLodingProgress.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogLodingProgress.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialogLodingProgress.setContentView(R.layout.dialog_loading);
        TextView tv_dialogMessage = dialogLodingProgress.findViewById(R.id.tv_dialogMessage);
        SmoothRoundProgressBar smoothRoundProgressBar = dialogLodingProgress.findViewById(R.id.pg_dialogLoading);
        smoothRoundProgressBar.setEndColor(R.color.colorAccent);
        if (!message.equals("") || message != null) {
            tv_dialogMessage.setText(message);
        }
        if (dialogLodingProgress.isShowing()) {
            return;
        }
        dialogLodingProgress.setCancelable(isCancelable);
        UIUtils.showDialog(context, dialogLodingProgress);
    }

    /**
     * 用来隐藏等待中的Dialog。可以自定义显示要提示的文字
     */
    public static void hideLoadingProgressDialog(Context context) {
        UIUtils.hideDialog(context, dialogLodingProgress);
    }



    /*------------------------------------------------这里显示用于找回密码的Dialog-----------------------------------------------------------------------*/
    public void showForgetPasswordDialog(Context context, Boolean isCancelable){
        dialogForgetPassword = new Dialog(context,R.style.style_dialog);
        dialogForgetPassword.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogForgetPassword.setContentView(R.layout.dialog_menu_bottom_chooseforgetpassword);
        Button bt_findpwdByPhone=dialogForgetPassword.findViewById(R.id.bt_findpwdByPhone);
        Button bt_findpwdByVerifiedEmail=dialogForgetPassword.findViewById(R.id.bt_findpwdByVerifiedEmail);
        Button bt_findpwdBySecurityQuestion=dialogForgetPassword.findViewById(R.id.bt_findpwdBySecurityQuestion);
        Button bt_findpwdByWorkstuff=dialogForgetPassword.findViewById(R.id.bt_findpwdByWorkstuff);

        Window window = dialogForgetPassword.getWindow();
        window.setBackgroundDrawableResource(android.R.color.transparent);
        window.setWindowAnimations(R.style.dialog_animation);
        window.setGravity(Gravity.BOTTOM);
        window.getDecorView().setPadding(0, 0, 0, 0);

        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(lp);


        bt_findpwdByPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (findpwdByPhone!=null){
                    findpwdByPhone.doFind();
                }
            }
        });
        bt_findpwdByVerifiedEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (findpwdByVerifyEmail!=null){
                    findpwdByVerifyEmail.doFind();
                }
            }
        });
        bt_findpwdBySecurityQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (findpwdBySecurityQuestion!=null){
                    findpwdBySecurityQuestion.doFind();
                }
            }
        });
        bt_findpwdByWorkstuff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (findpwdByWorkdtuff!=null){
                    findpwdByWorkdtuff.doFind();
                }
            }
        });
        if (dialogForgetPassword.isShowing()) {
            return;
        }
        dialogForgetPassword.setCancelable(isCancelable);
        UIUtils.showDialog(context, dialogForgetPassword);
    }
    /**
     * 用来隐藏等待中的Dialog。可以自定义显示要提示的文字
     */
    public void hideForgetPasswordDialog(Context context) {
        UIUtils.hideDialog(context, dialogForgetPassword);
    }

    private ForgetPassowordInf.FindpwdByPhone findpwdByPhone;
    public void clickOnFindpwdByPhone(ForgetPassowordInf.FindpwdByPhone findpwdByPhone){
        this.findpwdByPhone=findpwdByPhone;
    }
    private ForgetPassowordInf.FindpwdByVerifyEmail findpwdByVerifyEmail;
    public void clickOnFindpwdByVerifyEmail(ForgetPassowordInf.FindpwdByVerifyEmail findpwdByVerifyEmail){
        this.findpwdByVerifyEmail=findpwdByVerifyEmail;
    }
    private ForgetPassowordInf.FindpwdBySecurityQuestion findpwdBySecurityQuestion;
    public void clickOnFindpwdBySecurityQuestion(ForgetPassowordInf.FindpwdBySecurityQuestion findpwdBySecurityQuestion){
        this.findpwdBySecurityQuestion=findpwdBySecurityQuestion;
    }
    private ForgetPassowordInf.FindpwdByWorkdtuff findpwdByWorkdtuff;
    public void clickOnFindpwdByWorkdtuff(ForgetPassowordInf.FindpwdByWorkdtuff findpwdByWorkdtuff){
        this.findpwdByWorkdtuff=findpwdByWorkdtuff;
    }


}
