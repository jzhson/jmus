package com.tronxincloud.bmobtest.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;

/**
 * Created by Jzhson Davis on 8/3/2018.
 */

public class UIUtils {


    /**
     *
     * 判断Dialog是否存活，显示Dialog
     *
     */
    public static Boolean showDialog(Context context, Dialog dialog){
        if (context==null){
            return false;
        }
        if (dialog==null){
            return false;
        }
        if (context instanceof Activity){
            if (((Activity) context).isFinishing()){
                return false;
            }
        }
        dialog.show();
        return true;
    }

    /**
     *
     * 判断Dialog是否存活，隐藏Dialog
     *
     */
    public static Boolean hideDialog(Context context, Dialog dialog){
        if (context==null){
            return false;
        }
        if (dialog==null){
            return false;
        }
        if (context instanceof Activity){
            if (((Activity) context).isFinishing()){
                return false;
            }
        }
        dialog.dismiss();
        return true;
    }








}
