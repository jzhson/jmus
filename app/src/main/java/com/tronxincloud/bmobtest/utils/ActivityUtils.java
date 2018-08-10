package com.tronxincloud.bmobtest.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Jzhson Davis on 8/3/2018.
 */

public final class ActivityUtils {

    private ActivityUtils(){

    }

    public static void toActivity(Context context,Class c){
        Intent intent=new Intent(context,c);
        context.startActivity(intent);
        ((Activity)context).finish();
    }
}
