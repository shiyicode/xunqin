package com.web.entity;

/**
 * Created by Administrator on 2016/12/15 0015.
 */
public class Realmess {
    private int id;                 //实名认证表ID
    private int user_id=0;     //用户信息ID
    private String real_name;       //真实姓名
    private String id_number;       //身份证号
    private String province_city;   //籍贯
    private String address;         //详细住址

    public Realmess(){}

    public Realmess(int id, int user_id, String real_name, String id_number, String province_city, String address) {
        this.id = id;
        this.user_id = user_id;
        this.real_name = real_name;
        this.id_number = id_number;
        this.province_city = province_city;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getReal_name() {
        return real_name;
    }

    public void setReal_name(String real_name) {
        this.real_name = real_name;
    }

    public String getId_number() {
        return id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }

    public String getProvince_city() {
        return province_city;
    }

    public void setProvince_city(String province_city) {
        this.province_city = province_city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
