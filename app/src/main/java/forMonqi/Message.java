package forMonqi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 20113966 on 10-09-2016.
 */
public class Message {


    private String latitide;
    private String longitude;
    private Integer wifi;
    private Integer battery;
    private List<AppInfo> appInfo = new ArrayList<AppInfo>();

    public String getLatitide() {
        return latitide;
    }

    public void setLatitide(String latitide) {
        this.latitide = latitide;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Integer getWifi() {
        return wifi;
    }

    public void setWifi(Integer wifi) {
        this.wifi = wifi;
    }

    public Integer getBattery() {
        return battery;
    }

    public void setBattery(Integer battery) {
        this.battery = battery;
    }

    public List<AppInfo> getAppInfo() {
        return appInfo;
    }
    public void setAppInfo(List<AppInfo> appInfo) {
        this.appInfo = appInfo;
    }
}
