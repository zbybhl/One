package com.zhixing.staffid.ui.pojo;

import android.support.annotation.NonNull;

import java.util.Date;

/**
 * created by zhaobiying
 * on 2018/4/28
 * 用于日期列表的bean类
 */
public class DayList  implements Comparable<DayList>{

    private String id;
    private String img_url;
    private String date;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public int compareTo(@NonNull DayList dayList) {

        if(date.compareTo(dayList.date)>0)
            return -1;
        if(date.compareTo(dayList.date)<0)
            return 1;
        return 0;
    }
}
