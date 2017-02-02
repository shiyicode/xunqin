package com.web.entity;

/**
 * Created by Administrator on 2016/12/23 0023.
 */
public class Letter {
    private int id;                 //站内信ID
    private int user_id=0;            //目的用户id
    private int fromuser_id=0;        //发送用户id
    private String title;           //标题
    private String content;         //内容
    private String createdate;      //发送时间
    private int isread_flag=0;        //已读标志:0 默认,1 未读,2 已读

    public Letter(){}

    public Letter(int id, int user_id, int fromuser_id, String title, String content, String createdate, int isread_flag) {
        this.id = id;
        this.user_id = user_id;
        this.fromuser_id = fromuser_id;
        this.title = title;
        this.content = content;
        this.createdate = createdate;
        this.isread_flag = isread_flag;
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

    public int getFromuser_id() {
        return fromuser_id;
    }

    public void setFromuser_id(int fromuser_id) {
        this.fromuser_id = fromuser_id;
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

    public int getIsread_flag() {
        return isread_flag;
    }

    public void setIsread_flag(int isread_flag) {
        this.isread_flag = isread_flag;
    }
}
