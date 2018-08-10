package com.tronxincloud.bmobtest.utils;

import android.app.Activity;
import android.os.Build;
import android.view.Gravity;
import android.widget.Toast;

import com.onurkaganaldemir.ktoastlib.KToast;
import com.tronxincloud.bmobtest.R;
import com.tronxincloud.bmobtest.common.MyApplication;

import es.dmoral.toasty.Toasty;

/**
 * Created by Jzhson Davis on 8/5/2018.
 */

public class ToastUtils {

    //吐司
    public static final int T_COMMON = 0;
    public static final int T_ERROR = 1;
    public static final int T_SUCCESS = 2;
    public static final int T_INFO = 3;
    public static final int T_WARNING = 4;
    private static Toast toast;
    public static void d(String message, boolean isLengthLong, int type) {
        int during;
        if (isLengthLong) {
            during = Toast.LENGTH_LONG;
        } else {
            during = Toast.LENGTH_SHORT;
        }
        if (toast != null) {
            toast.cancel();
        }

        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT) {
            Toast.makeText(MyApplication.context,message,Toast.LENGTH_LONG).show();
            return;
        }
        switch (type) {
            case T_COMMON:
                toast = Toasty.normal(MyApplication.context, message, during);
                break;
            case T_ERROR:
                toast = Toasty.error(MyApplication.context, message, during);
                break;
            case T_SUCCESS:
                toast = Toasty.success(MyApplication.context, message, during);
                break;
            case T_INFO:
                toast = Toasty.info(MyApplication.context, message, during);
                break;
            case T_WARNING:
                toast = Toasty.warning(MyApplication.context, message, during);
                break;
        }
        toast.show();
    }


    public static final int KT_SUCCESS = 5;
    public static final int KT_INFO = 6;
    public static final int KT_NORMAL = 7;
    public static final int KT_WARNING = 8;
    public static final int KT_ERROR = 9;
    public static void kTd(Activity activity,String message,int type) {
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT) {
            Toast.makeText(activity,message,Toast.LENGTH_LONG).show();
            return;
        }
        switch (type) {
            // Success
            case KT_SUCCESS:
                KToast.successToast(activity, message, Gravity.BOTTOM, KToast.LENGTH_AUTO);
                break;
            // Info
            case KT_INFO:
                KToast.infoToast(activity, message, Gravity.BOTTOM, KToast.LENGTH_SHORT);
                break;
            // Normal
            case KT_NORMAL:
//              KToast.normalToast(activity, message, Gravity.BOTTOM, KToast.LENGTH_LONG, R.drawable.ic_infinite_white);
                KToast.normalToast(activity, message, Gravity.BOTTOM, KToast.LENGTH_LONG);
                break;
            // Warning
            case KT_WARNING:
                KToast.warningToast(activity, message, Gravity.BOTTOM, KToast.LENGTH_AUTO);
                break;
            // Error
            case KT_ERROR:
                KToast.errorToast(activity, message, Gravity.BOTTOM, KToast.LENGTH_AUTO);
                break;
        }
    }

    public static void kTd(Activity activity,String message,int color,int drawable){
        KToast.customColorToast(activity, message, Gravity.BOTTOM, KToast.LENGTH_AUTO, color,drawable);
    }

    public static void kTd(Activity activity,String message,int color,int text_color,int drawable){
        KToast.customColorToast(activity, message, Gravity.BOTTOM, KToast.LENGTH_AUTO, color,drawable);
        KToast.customBackgroudToast(activity, message, Gravity.BOTTOM, KToast.LENGTH_AUTO,color,text_color,drawable);
    }



}
