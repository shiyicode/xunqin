package com.web.entity;

/**
 * Created by Administrator on 2016/12/15 0015.
 */
public class Gaminrecord {
    private int id;                 //流浪儿上传记录ID
    private int gamin_id=0;            //流浪儿id
    private int user_id=0;            //用户id
    private int find_status=0;        //寻找状态
    private String pubdate;         //发布时间

    public Gaminrecord(){}

    public Gaminrecord(int id, int gamin_id, int user_id, int find_status, String pubdate) {
        this.id = id;
        this.gamin_id = gamin_id;
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

    public int getGamin_id() {
        return gamin_id;
    }

    public void setGamin_id(int gamin_id) {
        this.gamin_id = gamin_id;
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
