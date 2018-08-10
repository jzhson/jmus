package com.tronxincloud.bmobtest.custominterface;

/**
 * Created by Jzhson Davis on 8/3/2018.
 */

public interface ForgetPassowordInf {
    interface FindpwdByPhone{
        void doFind();
    }
    interface FindpwdByVerifyEmail{
        void doFind();
    }
    interface FindpwdBySecurityQuestion{
        void doFind();
    }
    interface FindpwdByWorkdtuff{
        void doFind();
    }
}
