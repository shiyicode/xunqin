package com.web.entity;

import java.sql.Timestamp;

/**
 * Created by Administrator on 2016/12/15 0015.
 */
public class Gaminmess {
    private int id;                     //流浪儿童信息表ID
    private String find_time;           //发现时间
    private int age=0;                    //估计年龄
    private int sex=2;                 //性别
    private int height=0;                 //估计身高
    private String find_place;          //发现地点GPS
    private String feature;             //特征
    private String picture_list;             //图片
    private String other_message;       //其他备注信息

    public Gaminmess(){}

    public Gaminmess(int id, String find_time, int age, int sex, int height, String find_place, String feature, String picture_list, String other_message) {
        this.id = id;
        this.find_time = find_time;
        this.age = age;
        this.sex = sex;
        this.height = height;
        this.find_place = find_place;
        this.feature = feature;
        this.picture_list = picture_list;
        this.other_message = other_message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFind_time() {
        return find_time;
    }

    public void setFind_time(String find_time) {
        this.find_time = find_time;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getFind_place() {
        return find_place;
    }

    public void setFind_place(String find_place) {
        this.find_place = find_place;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public String getPicture_list() {
        return picture_list;
    }

    public void setPicture_list(String picture_list) {
        this.picture_list = picture_list;
    }

    public String getOther_message() {
        return other_message;
    }

    public void setOther_message(String other_message) {
        this.other_message = other_message;
    }
}
