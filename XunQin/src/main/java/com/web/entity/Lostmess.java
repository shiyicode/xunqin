package com.web.entity;

import java.sql.Timestamp;

/**
 * Created by Administrator on 2016/12/15 0015.
 */
public class Lostmess {
    private int id;                 //丢失人员ID(寻亲信息表)
    private String name;            //失踪人姓名
    private int sex = 2;            //性别:1男 0女 2不清楚
    private int height = 0;         //身高
    private String birthday;        //出生年月
    private String native_place;    //籍贯
    private int blood_type=6;       //血型:1 A,2 B,3 O,4 AB,5 其他,6 不详
    private String lost_place;      //丢失地点
    private String lost_date;       //失踪日期
    private String picture_list;    //失踪人员图片
    private String feature;         //特征描述
    private int find_type=0;        //家寻宝贝or宝贝寻家:0默认值,1家寻宝贝,2宝贝寻家
    private String other_message;   //其他备注信息
    private String phone;           //联系电话
    private String email;           //联系邮箱

    public Lostmess(){
    }

    public Lostmess(int id, String name, int sex, int height, String birthday, String native_place, int blood_type, String lost_place, String lost_date, String picture_list, String feature, int find_type, String other_message, String phone, String email) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.height = height;
        this.birthday = birthday;
        this.native_place = native_place;
        this.blood_type = blood_type;
        this.lost_place = lost_place;
        this.lost_date = lost_date;
        this.picture_list = picture_list;
        this.feature = feature;
        this.find_type = find_type;
        this.other_message = other_message;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getNative_place() {
        return native_place;
    }

    public void setNative_place(String native_place) {
        this.native_place = native_place;
    }

    public int getBlood_type() {
        return blood_type;
    }

    public void setBlood_type(int blood_type) {
        this.blood_type = blood_type;
    }

    public String getLost_place() {
        return lost_place;
    }

    public void setLost_place(String lost_place) {
        this.lost_place = lost_place;
    }

    public String getLost_date() {
        return lost_date;
    }

    public void setLost_date(String lost_date) {
        this.lost_date = lost_date;
    }

    public String getPicture_list() {
        return picture_list;
    }

    public void setPicture_list(String picture_list) {
        this.picture_list = picture_list;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public int getFind_type() {
        return find_type;
    }

    public void setFind_type(int find_type) {
        this.find_type = find_type;
    }

    public String getOther_message() {
        return other_message;
    }

    public void setOther_message(String other_message) {
        this.other_message = other_message;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
