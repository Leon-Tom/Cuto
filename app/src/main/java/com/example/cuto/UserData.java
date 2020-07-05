package com.example.cuto;

public class UserData {

    private int userId;       //用户Id
    private String userName;  //用户名
    private String userPwad;  //用户密码
    private String userEmail; //用户邮箱


    public UserData(){
    }

    public UserData(String userName,String userPwad, String userEmail){
        this.userName  = userName;
        this.userPwad  = userPwad;
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPwad() {
        return userPwad;
    }

    public String getUserEmail() {
        return userEmail;
    }

    }
