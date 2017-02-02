package com.web.entity;

/**
 * Created by TongYiMing on 2016/12/20.
 */
public class Blogleave {
    private int id;                 //留言表id
    private int floor_id=0;           //楼号(层数)
    private int leave_id=0;           //留言用户ID
    private int receive_id=0;         //被留言用户ID
    private int main_id=0;            //动态ID
    private String leave_content;   //留言内容
    private String createdate;      //发布时间
    private int heart_num=0;          //爱心数量

    public  Blogleave(){}

    public Blogleave(int id, int floor_id, int leave_id, int receive_id, int main_id, String leave_content, String createdate, int heart_num) {
        this.id = id;
        this.floor_id = floor_id;
        this.leave_id = leave_id;
        this.receive_id = receive_id;
        this.main_id = main_id;
        this.leave_content = leave_content;
        this.createdate = createdate;
        this.heart_num = heart_num;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFloor_id() {
        return floor_id;
    }

    public void setFloor_id(int floor_id) {
        this.floor_id = floor_id;
    }

    public int getLeave_id() {
        return leave_id;
    }

    public void setLeave_id(int leave_id) {
        this.leave_id = leave_id;
    }

    public int getReceive_id() {
        return receive_id;
    }

    public void setReceive_id(int receive_id) {
        this.receive_id = receive_id;
    }

    public int getMain_id() {
        return main_id;
    }

    public void setMain_id(int main_id) {
        this.main_id = main_id;
    }

    public String getLeave_content() {
        return leave_content;
    }

    public void setLeave_content(String leave_content) {
        this.leave_content = leave_content;
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
