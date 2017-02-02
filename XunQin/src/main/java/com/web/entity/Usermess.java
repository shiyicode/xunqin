package com.web.entity;

/**
 * Created by Administrator on 2016/12/15 0015.
 */
public class Usermess {
    private int id;                 //用户信息表ID
    private int user_id;            //用户ID
    private int realname_flag=0;      //实名认证标志:已实名(实名id),未实名(-1),待审核(1),初始值(0)
    private String picture="1.jpg";         //用户头像
    private String username;        //用户昵称
    private int love_count=0;         //爱心值
    private int age=0;                //年龄
    private int sex=2;                //性别:1男 0女 2不清楚
    private String telephone;       //电话
    private double account_balance; //账户余额

    public Usermess(){}

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Usermess(int id, int user_id, int realname_flag, String picture, String username, String email, int love_count, int age, int sex, String telephone, double account_balance) {
        this.id = id;
        this.user_id = user_id;
        this.realname_flag = realname_flag;
        this.picture = picture;
        this.username = username;
        this.love_count = love_count;
        this.age = age;
        this.sex = sex;
        this.telephone = telephone;
        this.account_balance = account_balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRealname_flag() {
        return realname_flag;
    }

    public void setRealname_flag(int realname_flag) {
        this.realname_flag = realname_flag;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getLove_count() {
        return love_count;
    }

    public void setLove_count(int love_count) {
        this.love_count = love_count;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public double getAccount_balance() {
        return account_balance;
    }

    public void setAccount_balance(double account_balance) {
        this.account_balance = account_balance;
    }
}
