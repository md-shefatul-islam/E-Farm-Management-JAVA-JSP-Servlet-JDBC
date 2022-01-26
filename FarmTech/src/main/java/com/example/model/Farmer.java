package com.example.model;

public class Farmer {

        public int id;
        public String uname;
        public String name;
        public String email;
        public String phone;
        public String city;
        public String password;
        public String gender;
        public String dob;
        public String balance;


        public Farmer() {
        }

    public Farmer(String uname, String password) {
        this.uname = uname;
        this.password = password;
    }

    public Farmer(String uname, String name, String email, String phone, String city, String password, String gender, String dob) {
        this.uname = uname;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.city = city;
        this.password = password;
        this.gender = gender;
        this.dob = dob;
    }

    public Farmer(String uname, String name, String email, String phone, String city, String password, String gender, String dob, String balance) {
        this.uname = uname;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.city = city;
        this.password = password;
        this.gender = gender;
        this.dob = dob;
        this.balance = balance;
    }

    public Farmer(int id, String uname, String name, String email, String phone, String city, String password, String gender, String dob, String balance) {
        this.id = id;
        this.uname = uname;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.city = city;
        this.password = password;
        this.gender = gender;
        this.dob = dob;
        this.balance = balance;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }
}
