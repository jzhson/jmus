package com.tronxincloud.bmobtest.custominterface;

/**
 * Created by Jzhson Davis on 8/6/2018.
 */

public interface RegisterUserInf {
    interface registerUser{
        void success();
        void error(int errorcode,String message);
    }

    interface checkDevice{
        void done(boolean has);
        void error(int errorcode,String message);
    }

    interface checkUserExist{
        void done(boolean has);
        void error(int errorcode,String message);
    }
}
