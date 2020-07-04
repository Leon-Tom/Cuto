package com.example.cuto;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class UserDAO{

     private UserDataManage userDataManage;
     private SQLiteDatabase sqLiteDatabase;
     private Context context;

     public UserDAO(Context context){
         this.context = context;
         userDataManage = new UserDataManage(context);
     }


     //打开数据库
     public void openDataBase() throws SQLException{
         userDataManage = new UserDataManage(context);
         sqLiteDatabase = userDataManage.getWritableDatabase();

     }


     //关闭数据库
     public void closeDataBase() throws SQLException{
            sqLiteDatabase.close();
     }


     //添加用户（注册）
     private long addUser(UserData userData){
         String u_name = userData.getUserName();
         String u_pawd = userData.getUserPwad();
         String u_email = userData.getUserEmail();
         ContentValues values = new ContentValues();
         values.put("user_name",u_name);
         values.put("user_pawd",u_pawd);
         values.put("user_email",u_email);
         return sqLiteDatabase.insert("user_book","_id",values);
     }

     //查询注册用户是否已经存在 (仅仅通过用户名)
     // "select  from user where u_name = ’张三‘ "  精确查找
     public boolean isByName(String uName){
         String sql = "select  from user where u_name = ’张三‘ ";
         return true;  //用户不存在返回true
     }


     //用户登录
     public void userSubmit(){

     }


 }
