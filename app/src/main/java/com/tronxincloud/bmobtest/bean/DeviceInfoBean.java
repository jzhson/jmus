package com.tronxincloud.bmobtest.bean;

/**
 * Created by Jzhson Davis on 8/6/2018.
 */

public class DeviceInfoBean {
    String username;
    String deviceName;
    String deviceId;
    Boolean deviceBlocked;
    Integer deviceRegUers;

    public DeviceInfoBean() {
    }

    public DeviceInfoBean(String username, String deviceName, String deviceId, Boolean deviceBlocked, Integer deviceRegUers) {
        this.username = username;
        this.deviceName = deviceName;
        this.deviceId = deviceId;
        this.deviceBlocked = deviceBlocked;
        this.deviceRegUers = deviceRegUers;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Boolean getDeviceBlocked() {
        return deviceBlocked;
    }

    public void setDeviceBlocked(Boolean deviceBlocked) {
        this.deviceBlocked = deviceBlocked;
    }

    public Integer getDeviceRegUers() {
        return deviceRegUers;
    }

    public void setDeviceRegUers(Integer deviceRegUers) {
        this.deviceRegUers = deviceRegUers;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DeviceInfoBean)) return false;

        DeviceInfoBean that = (DeviceInfoBean) o;

        if (getUsername() != null ? !getUsername().equals(that.getUsername()) : that.getUsername() != null)
            return false;
        if (getDeviceName() != null ? !getDeviceName().equals(that.getDeviceName()) : that.getDeviceName() != null)
            return false;
        if (getDeviceId() != null ? !getDeviceId().equals(that.getDeviceId()) : that.getDeviceId() != null)
            return false;
        if (getDeviceBlocked() != null ? !getDeviceBlocked().equals(that.getDeviceBlocked()) : that.getDeviceBlocked() != null)
            return false;
        return getDeviceRegUers() != null ? getDeviceRegUers().equals(that.getDeviceRegUers()) : that.getDeviceRegUers() == null;
    }

    @Override
    public int hashCode() {
        int result = getUsername() != null ? getUsername().hashCode() : 0;
        result = 31 * result + (getDeviceName() != null ? getDeviceName().hashCode() : 0);
        result = 31 * result + (getDeviceId() != null ? getDeviceId().hashCode() : 0);
        result = 31 * result + (getDeviceBlocked() != null ? getDeviceBlocked().hashCode() : 0);
        result = 31 * result + (getDeviceRegUers() != null ? getDeviceRegUers().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DeviceInfoBean{" +
                "username='" + username + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", deviceBlocked=" + deviceBlocked +
                ", deviceRegUers=" + deviceRegUers +
                '}';
    }
}
