package com.tronxincloud.bmobtest.bean;

import cn.bmob.v3.BmobUser;

/**
 * Created by Jzhson Davis on 8/2/2018.
 */

public class UserBean extends BmobUser {

//    JavaBean中仍然还是JavaBean数据，这些东西不变。

    private String sex;
    private String birthday;
    private Boolean isProUser;
    private String userIcon;
    private String userSignature;
    private String userNotes;






    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Boolean getProUser() {
        return isProUser;
    }

    public void setProUser(Boolean proUser) {
        isProUser = proUser;
    }

    public String getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(String userIcon) {
        this.userIcon = userIcon;
    }

    public String getUserSignature() {
        return userSignature;
    }

    public void setUserSignature(String userSignature) {
        this.userSignature = userSignature;
    }

    public String getUserNotes() {
        return userNotes;
    }

    public void setUserNotes(String userNotes) {
        this.userNotes = userNotes;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserBean)) return false;

        UserBean userInfo = (UserBean) o;

        if (!getSex().equals(userInfo.getSex())) return false;
        if (!getBirthday().equals(userInfo.getBirthday())) return false;
        if (!isProUser.equals(userInfo.isProUser)) return false;
        if (!getUserIcon().equals(userInfo.getUserIcon())) return false;
        if (!getUserSignature().equals(userInfo.getUserSignature())) return false;
        return getUserNotes().equals(userInfo.getUserNotes());
    }

    @Override
    public int hashCode() {
        int result = getSex().hashCode();
        result = 31 * result + getBirthday().hashCode();
        result = 31 * result + isProUser.hashCode();
        result = 31 * result + getUserIcon().hashCode();
        result = 31 * result + getUserSignature().hashCode();
        result = 31 * result + getUserNotes().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                ", isProUser=" + isProUser +
                ", userIcon='" + userIcon + '\'' +
                ", userSignature='" + userSignature + '\'' +
                ", userNotes='" + userNotes + '\'' +
                '}';
    }
}
