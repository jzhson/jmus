package com.tronxincloud.bmobtest.bmob.view.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.tronxincloud.bmobtest.R;
import com.tronxincloud.bmobtest.bean.UserBean;
import com.tronxincloud.bmobtest.bmob.present.UserRegisterPresent;
import com.tronxincloud.bmobtest.bmob.present.UserRegisterPresentImp;
import com.tronxincloud.bmobtest.bmob.view.UserRegisterView;
import com.tronxincloud.bmobtest.utils.ToastUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Jzhson Davis on 8/5/2018.
 */

public class UserRegisterActivity extends AppCompatActivity implements UserRegisterView, View.OnClickListener {
    private EditText et_ur_username;
    private EditText et_ur_password;
    private EditText et_ur_passwordSure;
    private Spinner sp_ur_gender;
    private TextView tv_ur_birthday;
    private Button btn_ur_submit;
    private  UserRegisterPresent userRegisterPresent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmob_userregister);
        userRegisterPresent=new UserRegisterPresentImp(this);
        initView();
        initData();
    }



    @Override
    public void showRegisterProgress(String message) {

    }

    @Override
    public void hideRegisterProgress() {

    }


    @Override
    public void showUserExist(String message) {
        ToastUtils.kTd(this,message,ToastUtils.KT_SUCCESS);
    }

    @Override
    public void shoeRegisterSuccessDialog(String message) {

    }

    @Override
    public void showNetError() {

    }

    @Override
    public void showFailedAlertDialog(String message) {
        ToastUtils.kTd(this,"注册失败！",ToastUtils.KT_SUCCESS);
    }

    @Override
    public void hideFaildeAlerDialog() {

    }

    @Override
    public void showInvalidateData(String message) {
        ToastUtils.kTd(this,message,ToastUtils.KT_SUCCESS);
    }

    private void initView() {
        et_ur_username = (EditText) findViewById(R.id.et_ur_username);
        et_ur_password = (EditText) findViewById(R.id.et_ur_password);
        et_ur_passwordSure = (EditText) findViewById(R.id.et_ur_passwordSure);
        sp_ur_gender = (Spinner) findViewById(R.id.sp_ur_gender);
        tv_ur_birthday = (TextView) findViewById(R.id.tv_ur_birthday);
        tv_ur_birthday.setOnClickListener(this);
        btn_ur_submit = (Button) findViewById(R.id.btn_ur_submit);
        btn_ur_submit.setOnClickListener(this);
        ArrayAdapter<String> genderAdapter=new ArrayAdapter<>(this,R.layout.item_register_gender,genderArray);
        sp_ur_gender.setAdapter(genderAdapter);
        sp_ur_gender.setOnItemSelectedListener(new MySelectedListener());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_ur_submit:
                submit();
                break;
            case R.id.tv_ur_birthday:
                pickBirthday();
                break;
        }
    }

    private void pickBirthday() {
        final Calendar selectedDate = Calendar.getInstance();
        Calendar startDate = Calendar.getInstance();
        //startDate.set(2013,1,1);正确设置方式 原因：注意事项有说明
        Calendar endDate = Calendar.getInstance();
        Calendar defalutDate=Calendar.getInstance();
        startDate.set(endDate.get(Calendar.YEAR)-70,endDate.get(Calendar.MONTH),endDate.get(Calendar.DAY_OF_MONTH));
        defalutDate.set(endDate.get(Calendar.YEAR)-22,endDate.get(Calendar.MONTH),endDate.get(Calendar.DAY_OF_MONTH));
        TimePickerView pvTime = new TimePickerBuilder(this, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
//                SimpleDateFormat dateFormat=new SimpleDateFormat("YYYY年mm月DD日");
                selectedDate.setTime(date);
                tv_ur_birthday.setText(selectedDate.get(Calendar.YEAR)+"年"+(selectedDate.get(Calendar.MONTH)+1)+"月"+selectedDate.get(Calendar.DAY_OF_MONTH)+"日");
            }
        })
                .setType(new boolean[]{true, true, true, false, false, false})// 默认全部显示
                .setCancelText("取消")//取消按钮文字
                .setSubmitText("确定")//确认按钮文字
                .setContentTextSize(18)
                .setTitleSize(20)//标题文字大小
                .setTitleText("选择您的出生日期")//标题文字
                .setOutSideCancelable(false)//点击屏幕，点在控件外部范围时，是否取消显示
                .isCyclic(true)//是否循环滚动
                .setTitleColor(Color.BLACK)//标题文字颜色
                .setSubmitColor(Color.BLUE)//确定按钮文字颜色
                .setCancelColor(Color.BLACK)//取消按钮文字颜色
                .setTitleBgColor(Color.parseColor("#FFFFFF"))//标题背景颜色
                .setBgColor(Color.parseColor("#fafafa"))//滚轮背景颜色 Night mode
                .setTextColorCenter(Color.parseColor("#000000"))
                .setTextColorOut(Color.parseColor("#000000"))
                .setDate(defalutDate)// 如果不设置的话，默认是系统时间*/
                .setRangDate(startDate,endDate)//起始终止年月日设定
                .setLabel("年","月","日","","","")//默认设置为年月日时分秒
                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                .isDialog(true)//是否显示为对话框样式
                .build();
        pvTime.show();
    }

    private void submit() {
        // validate
        String username = et_ur_username.getText().toString().trim();
        if (TextUtils.isEmpty(username)) {
            ToastUtils.kTd(this,"邮箱账号不能为空",ToastUtils.KT_ERROR);
            return;
        }

        String password = et_ur_password.getText().toString().trim();
        if (TextUtils.isEmpty(password)) {
            ToastUtils.kTd(this,"密码不能为空",ToastUtils.KT_ERROR);
            return;
        }

        String passwordSure = et_ur_passwordSure.getText().toString().trim();
        if (TextUtils.isEmpty(passwordSure)) {
            ToastUtils.kTd(this,"确认密码不能为空",ToastUtils.KT_ERROR);
            return;
        }

        if(sp_ur_gender.getSelectedItem().toString()==null || sp_ur_gender.getSelectedItem().toString().equals("")){
            ToastUtils.kTd(this,"性别尚未选择",ToastUtils.KT_ERROR);
            return;
        }
        if (tv_ur_birthday.getText().toString()==null || tv_ur_birthday.getText().toString().equals("")){
            ToastUtils.kTd(this,"还没有选择出生日期",ToastUtils.KT_ERROR);
            return;
        }
        UserBean userBean=new UserBean();
        userBean.setUsername(et_ur_username.getText().toString());
        userBean.setPassword(et_ur_password.getText().toString());
        userRegisterPresent.checkUsername(et_ur_username.getText().toString());
//        userRegisterPresent.regist(userBean);
    }



    private void initData() {
        et_ur_username.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

            }
        });

        et_ur_password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

            }
        });

        et_ur_passwordSure.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

            }
        });

        et_ur_username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        et_ur_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        et_ur_passwordSure.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private String[] genderArray={"男","女"};
    private class MySelectedListener implements AdapterView.OnItemSelectedListener{

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}
