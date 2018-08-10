package com.tronxincloud.bmobtest.bmob.model;

import android.support.v7.app.AppCompatActivity;
import com.tronxincloud.bmobtest.bean.UserBean;
import com.tronxincloud.bmobtest.custominterface.RegisterUserInf;
import java.util.List;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by Jzhson Davis on 8/6/2018.
 */

public class UserRegisterModelImp extends AppCompatActivity implements UserRegisterModel {

    @Override
    public void registUser(UserBean userBean) {
        userBean.signUp(new SaveListener<UserBean>() {
            @Override
            public void done(UserBean userBean, BmobException e) {
                if (e==null){
                    if (registerUserIntf!=null){
                        registerUserIntf.success();
                    }
                }
                else{
                    int errorcode=e.getErrorCode();
                    if (registerUserIntf!=null){
                        registerUserIntf.error(errorcode,"注册失败！");
                    }
                }
            }
        });
    }

    @Override
    public void checkUserExist(String username) {
        BmobQuery<BmobUser> beanBmobQuery=new BmobQuery<>();
        beanBmobQuery.addWhereEqualTo("username",username);
        beanBmobQuery.findObjects(new FindListener<BmobUser>() {
            @Override
            public void done(List<BmobUser> list, BmobException e) {
                if (e==null) {
                    if (list.size() == 0) {
                        if (checkUserExistIntf != null) {
                            checkUserExistIntf.done(false);
                        }
                    }
                    else {
                        if (checkUserExistIntf != null) {
                            checkUserExistIntf.done(true);
                        }
                    }
                }
                else{
                    if (checkUserExistIntf!=null){
                        checkUserExistIntf.error(e.getErrorCode(),"信息检索失败！");
                    }
                }

            }
        });

    }


    @Override
    public void checkDevice(String deviceSN) {

    }

    private RegisterUserInf.checkDevice checkDeviceIntf;
    public void setOnCheckDeviceResult(RegisterUserInf.checkDevice checkDeviceIntf){
        this.checkDeviceIntf = checkDeviceIntf;
    }

    private RegisterUserInf.checkUserExist checkUserExistIntf;
    public void setOncheckUserExistResult(RegisterUserInf.checkUserExist checkUserExistIntf){
        this.checkUserExistIntf = checkUserExistIntf;
    }


    private RegisterUserInf.registerUser registerUserIntf;
    public void setOnRegisterUserResult(RegisterUserInf.registerUser registerUserIntf){
        this.registerUserIntf = registerUserIntf;
    }
}
