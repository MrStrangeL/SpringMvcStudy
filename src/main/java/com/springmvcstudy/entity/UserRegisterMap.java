package com.springmvcstudy.entity;

import java.util.Map;

public class UserRegisterMap {
    private Map<String,UserRegister> users;

    public UserRegisterMap() {
    }

    public UserRegisterMap(Map<String, UserRegister> users) {
        this.users = users;
    }

    public Map<String, UserRegister> getUsers() {
        return users;
    }

    public void setUsers(Map<String, UserRegister> users) {
        this.users = users;
    }
}
