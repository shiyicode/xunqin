package com.web.entity;

/**
 * Created by shiyi on 16/9/23.
 */
public class User {
        private int id;                     //用户id(帐号表)
        private int qq_id=0;                  //QQ ID
        private int wx_id=0;                  //微信 ID
        private int wb_id=0;                  //微博 ID
        private String qq_number;              //QQ账号
        private String wx_number;           //微信账号
        private String wb_number;           //微博账号
        private int is_open=0;                //是否公开(0默认,1不公开,2公开)
        private String email;               //电子邮箱
        private String password;            //密码

        public User(){}

        public User(int id, int qq_id, int wx_id, int wb_id, String qq_number, String wx_number, String wb_number, int is_open, String email, String password) {
            this.id = id;
            this.qq_id = qq_id;
            this.wx_id = wx_id;
            this.wb_id = wb_id;
            this.qq_number = qq_number;
            this.wx_number = wx_number;
            this.wb_number = wb_number;
            this.is_open = is_open;
            this.email = email;
            this.password = password;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getQq_id() {
            return qq_id;
        }

        public void setQq_id(int qq_id) {
            this.qq_id = qq_id;
        }

        public int getWx_id() {
            return wx_id;
        }

        public void setWx_id(int wx_id) {
            this.wx_id = wx_id;
        }

        public int getWb_id() {
            return wb_id;
        }

        public void setWb_id(int wb_id) {
            this.wb_id = wb_id;
        }

        public String getQq_number() {
            return qq_number;
        }

        public void setQq_number(String qq_number) {
            this.qq_number = qq_number;
        }

        public String getWx_number() {
            return wx_number;
        }

        public void setWx_number(String wx_number) {
            this.wx_number = wx_number;
        }

        public String getWb_number() {
            return wb_number;
        }

        public void setWb_number(String wb_number) {
            this.wb_number = wb_number;
        }

        public int getIs_open() {
            return is_open;
        }

        public void setIs_open(int is_open) {
            this.is_open = is_open;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
}
