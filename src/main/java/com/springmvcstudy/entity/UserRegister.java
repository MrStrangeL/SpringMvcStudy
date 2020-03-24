package com.springmvcstudy.entity;

public class UserRegister {
    private String userName;
    private String userPwd;

    public UserRegister() {
    }

    public UserRegister(String userName, String userPwd) {
        this.userName = userName;
        this.userPwd = userPwd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    @Override
    public String toString() {
        return "UserRegister [userName="+userName+",userPwd="+userPwd+"]";
    }
}
