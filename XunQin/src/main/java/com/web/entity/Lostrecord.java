package com.web.entity;

/**
 * Created by Administrator on 2016/12/15 0015.
 */
public class Lostrecord {


    private int id;             //寻亲记录表ID
    private int lost_id=0;        //寻亲id
    private int user_id=0;        //用户id
    private int find_status=0;    //寻找状态
    private String pubdate;     //发布时间

    public Lostrecord(){}

    public Lostrecord(int id, int lost_id, int user_id, int find_status, String pubdate) {
        this.id = id;
        this.lost_id = lost_id;
        this.user_id = user_id;
        this.find_status = find_status;
        this.pubdate = pubdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLost_id() {
        return lost_id;
    }

    public void setLost_id(int lost_id) {
        this.lost_id = lost_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getFind_status() {
        return find_status;
    }

    public void setFind_status(int find_status) {
        this.find_status = find_status;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }
}
