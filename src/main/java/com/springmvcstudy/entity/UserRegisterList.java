package com.springmvcstudy.entity;

import java.util.ArrayList;
import java.util.List;

public class UserRegisterList {
    private List<UserRegister> users=new ArrayList<>();

    public UserRegisterList() {
    }

    public UserRegisterList(List<UserRegister> users) {
        this.users = users;
    }

    public List<UserRegister> getUsers() {
        return users;
    }

    public void setUsers(List<UserRegister> users) {
        this.users = users;
    }
}
