package com.example.icbt;

public class userCustomer{

    private String username;
    private String password;
    private String email;
    private String mobile;

    public userCustomer (){}

    public userCustomer ( String user, String pass, String mail, String mobi){
        username=user;
        password=pass;
        email=mail;
        mobile=mobi;

    }


    public String getUsername () {
        return username;
    }

    public void setUsername ( String user ) {
        this.username = user;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword ( String pass ) {
        this.password = pass;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail ( String mail ) {
        this.email = mail;
    }

    public String getMobile () {
        return mobile;
    }

    public void setMobile ( String mobi ) {
        this.mobile = mobi;
    }
}
