package com.example.cuto;

public class UserData {

    private int userId;       //用户Id
    private String userName;  //用户名
    private String userPwad;  //用户密码
    private String userEmail; //用户邮箱


    public UserData(String userName,String userPwad,String userEmail){
        this.userName  = userName;
        this.userPwad  = userPwad;
        this.userEmail = userEmail;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwad() {
        return userPwad;
    }

    public void setUserPwad(String userPwad) {
        this.userPwad = userPwad;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
