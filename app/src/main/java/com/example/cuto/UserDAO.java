package com.example.cuto;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class UserDAO{

     private UserDataManage userDataManage ;
     private SQLiteDatabase sqLiteDatabase = null;
     private Context context = null;
     private Cursor cursor;

     public UserDAO(Context context){
         this.context = context;
         userDataManage = new UserDataManage(context);
     }


     //打开数据库
     public void openDataBase() throws SQLException{
         userDataManage = new UserDataManage(context);
         sqLiteDatabase = userDataManage.getWritableDatabase();
         sqLiteDatabase.isOpen();
     }


     //关闭数据库
     public void closeDataBase() throws SQLException{
            sqLiteDatabase.close();
     }


     //添加用户（注册）
     public long addUser(UserData userData){
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
     // "select * from 表名 where u_name = ’张三‘ "  精确查找
     public int isByName(String uName){
         //String sql = " select user_name from user_book where  user_name" + "=" + uName;
         //db.execSQL(sql);
         int isOfno = 0;
         cursor = sqLiteDatabase.query("user_book",null,"user_name"+"="+uName,
                 null,null,null,null);
         if (cursor != null){
             isOfno = cursor.getCount();
             cursor.close();
         }
         return isOfno;
     }


     //用户登录
     public int userSubmit(String uName,String uPawd){
         int isOfno = 0;
         Cursor cursor = sqLiteDatabase.query("user_book", null,
                 "user_name"+"="+uName+" and user_pawd"+"="+uPawd,
                 null, null, null, null,null); //query()方法真的有毒
         if (cursor != null){
             isOfno = cursor.getCount();
             cursor.close();
         }
         return isOfno;
     }


 }
