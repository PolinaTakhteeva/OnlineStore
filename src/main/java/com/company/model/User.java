package com.company.model;

public class User {
    private int userId;
    private String login;
    private String passward;
    private String email;
    private String name;

    public User(){
        this.userId = 0;
        this.login = "";
        this.passward = "";
        this.email = "";
        this.name = "";
    }

    public User(int userId, String login,String passward, String email, String name) {
        this.userId = userId;
        this.login = login;
        this.passward = passward;
        this.email = email;
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public String getLogin() {
        return login;
    }

    public String getPassward() {
        return passward;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassward(String passward) {
        this.passward = passward;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", login='" + login + '\'' +
                ", passward='" + passward + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}
