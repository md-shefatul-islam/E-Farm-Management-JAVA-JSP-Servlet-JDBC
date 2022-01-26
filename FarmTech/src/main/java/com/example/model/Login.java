package com.example.model;

public class Login {
    int id;
    String uname;
    String password;
    String type;

    public Login() {
    }

    public Login(String uname, String password) {

        this.uname = uname;
        this.password = password;
    }

    public Login(String uname, String password, String type) {
        this.uname = uname;
        this.password = password;
        this.type = type;
    }

    public Login(int id, String uname, String password, String type) {
        this.id = id;
        this.uname = uname;
        this.password = password;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
