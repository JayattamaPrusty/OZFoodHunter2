/*
package com.wma.ozfoodhunter.BeanClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Sign_Up_Model implements Serializable {
    String firstname;
    String lastname;
    String email;
    String password;
    String mobile;

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("info")
    @Expose
    private Info info;

    public Sign_Up_Model(String firstname, String lastname, String email, String password, String mobile) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.mobile = mobile;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


    public static class Info {

        @SerializedName("user_id")
        @Expose
        private String userId;
        @SerializedName("user_email")
        @Expose
        private String userEmail;
        @SerializedName("mobile")
        @Expose
        private String mobile;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getUserEmail() {
            return userEmail;
        }

        public void setUserEmail(String userEmail) {
            this.userEmail = userEmail;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

    }

}*/



package com.wma.ozfoodhunter.BeanClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Sign_Up_Model implements Serializable {

    private String status;
    private String msg;
    private Info info;


    public class Info {
        private String in_user_id;
        private String st_user_email;
        private String st_mobile;
        private String admin_first_name;
        private String admin_last_name;
        private String referal;

        public String getUserId() {
            return in_user_id;
        }

        public void setUserId(String userId) {
            this.in_user_id = userId;
        }

        public String getUserEmail() {
            return st_user_email;
        }

        public void setUserEmail(String userEmail) {
            this.st_user_email = userEmail;
        }

        public String getMobile() {
            return st_mobile;
        }

        public void setMobile(String mobile) {
            this.st_mobile = mobile;
        }

        public String getReferal() {
            return referal;
        }

        public void setReferal(String referal) {
            this.referal = referal;
        }

        public String getAdmin_last_name() {
            return admin_last_name;
        }

        public void setAdmin_last_name(String admin_last_name) {
            this.admin_last_name = admin_last_name;
        }

        public String getAdmin_first_name() {
            return admin_first_name;
        }

        public void setAdmin_first_name(String admin_first_name) {
            this.admin_first_name = admin_first_name;
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }
}

