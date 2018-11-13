package com.baizhi.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Banner {
    private String b_id;
    private String b_title;
    private String b_imgPath;
    private String b_desc;
    private String b_status;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date b_date;

    public String getB_id() {
        return b_id;
    }

    public void setB_id(String b_id) {
        this.b_id = b_id;
    }

    public String getB_title() {
        return b_title;
    }

    public void setB_title(String b_title) {
        this.b_title = b_title;
    }

    public String getB_imgPath() {
        return b_imgPath;
    }

    public void setB_imgPath(String b_imgPath) {
        this.b_imgPath = b_imgPath;
    }

    public String getB_desc() {
        return b_desc;
    }

    public void setB_desc(String b_desc) {
        this.b_desc = b_desc;
    }

    public String getB_status() {
        return b_status;
    }

    public void setB_status(String b_status) {
        this.b_status = b_status;
    }

    public String getB_date() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(b_date);
    }

    public void setB_date(Date b_date) {
        this.b_date = b_date;
    }

    @Override
    public String toString() {
        return "Banner{" +
                "b_id='" + b_id + '\'' +
                ", b_title='" + b_title + '\'' +
                ", b_imgPath='" + b_imgPath + '\'' +
                ", b_desc='" + b_desc + '\'' +
                ", b_status='" + b_status + '\'' +
                ", b_date=" + b_date +
                '}';
    }

    public Banner() {
        super();
    }

    public Banner(String b_id, String b_title, String b_imgPath, String b_desc, String b_status, Date b_date) {
        this.b_id = b_id;
        this.b_title = b_title;
        this.b_imgPath = b_imgPath;
        this.b_desc = b_desc;
        this.b_status = b_status;
        this.b_date = b_date;
    }
}
