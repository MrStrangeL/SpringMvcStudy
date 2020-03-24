package com.springmvcstudy.entity;

import java.util.HashSet;
import java.util.Set;

public class UserRegisterSet {
    private Set<UserRegister> users=new HashSet<>();

    public UserRegisterSet() {
        users.add(new UserRegister());
        users.add(new UserRegister());
        users.add(new UserRegister());
    }

    public UserRegisterSet(Set<UserRegister> users) {
        this.users = users;
    }

    public Set<UserRegister> getUsers() {
        return users;
    }

    public void setUsers(Set<UserRegister> users) {
        this.users = users;
    }
}
