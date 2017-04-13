package com.wma.ozfoodhunter.BeanClasses;

/**
 * Created by Jayattama Prusty on 22-Mar-17.
 */


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Login_Model {

    private Boolean check_flg;
    private user_info user_info;
    private String error_msg;

    public Boolean getCheck_flg() {
        return check_flg;
    }

    public void setCheck_flg(Boolean check_flg) {
        this.check_flg = check_flg;
    }

    public Login_Model.user_info getUser_info() {
        return user_info;
    }

    public void setUser_info(Login_Model.user_info user_info) {
        this.user_info = user_info;
    }

    public String getError_msg() {
        return error_msg;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public class user_info{
        private String in_user_id;
        private String st_user_email;
        private String admin_first_name;
        private String admin_last_name;
        private String st_mobile;
        private String st_phone;
        private String user_loggedin;


        public String getIn_user_id() {
            return in_user_id;
        }

        public void setIn_user_id(String in_user_id) {
            this.in_user_id = in_user_id;
        }

        public String getSt_user_email() {
            return st_user_email;
        }

        public void setSt_user_email(String st_user_email) {
            this.st_user_email = st_user_email;
        }

        public String getAdmin_first_name() {
            return admin_first_name;
        }

        public void setAdmin_first_name(String admin_first_name) {
            this.admin_first_name = admin_first_name;
        }

        public String getAdmin_last_name() {
            return admin_last_name;
        }

        public void setAdmin_last_name(String admin_last_name) {
            this.admin_last_name = admin_last_name;
        }

        public String getSt_mobile() {
            return st_mobile;
        }

        public void setSt_mobile(String st_mobile) {
            this.st_mobile = st_mobile;
        }

        public String getSt_phone() {
            return st_phone;
        }

        public void setSt_phone(String st_phone) {
            this.st_phone = st_phone;
        }

        public String getUser_loggedin() {
            return user_loggedin;
        }

        public void setUser_loggedin(String user_loggedin) {
            this.user_loggedin = user_loggedin;
        }
    }


}


