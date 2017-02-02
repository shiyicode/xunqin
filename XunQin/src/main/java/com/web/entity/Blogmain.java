package com.web.entity;

/**
 * Created by TongYiMing on 2016/12/20.
 */
public class Blogmain {
    private int id;                 //动态表id
    private int user_id=0;            //用户ID
    private String title;           //标题
    private String content;         //内容
    private String createdate;      //发布时间
    private int heart_num=0;          //爱心数量

    public Blogmain(){}

    public Blogmain(int id, int user_id, String title, String content, String createdate, int heart_num) {
        this.id = id;
        this.user_id = user_id;
        this.title = title;
        this.content = content;
        this.createdate = createdate;
        this.heart_num = heart_num;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    public int getHeart_num() {
        return heart_num;
    }

    public void setHeart_num(int heart_num) {
        this.heart_num = heart_num;
    }
}
