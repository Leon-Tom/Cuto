package com.example.cuto;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

 public class UserDAO extends UserDataManage {

     private UserDataManage userDataManage = null;
     private SQLiteDatabase sqLiteDatabase = null;
     private Context mContext = null;

     public UserDAO(Context context){
         super(context);
         mContext = context;
     }


     //打开数据库
     public void openDataBase() throws SQLException{
         userDataManage = new UserDAO(mContext);
         sqLiteDatabase = userDataManage.getWritableDatabase();

     }


     //关闭数据库
     public void closeDataBase() throws SQLException{
            sqLiteDatabase.close();
     }

     //查询注册用户是否已经存在
     public boolean isByName(){

         return false;  //用户不存在返回false
     }


     //用户登录
     public void userSubmit(){

     }


 }
