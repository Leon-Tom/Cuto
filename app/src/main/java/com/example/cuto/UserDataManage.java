package com.example.cuto;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class UserDataManage extends SQLiteOpenHelper {

    private static final String TAG = "UserDataManage";
    private static final String DB_NAME = "user_data";
//  private  static final String TABLE_NAME = "user_book";
    private static final int VERSION = 1;                  //数据库版本号

    public UserDataManage(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
         String sql = "create table user_book(_id integer primary key autoincrement, user_name varchar(20),user_pawd varchar(20),user_email varchar(20))";
         db.execSQL("drop table if exists user_book");
         db.execSQL(sql);
         Log.i(TAG,sql);
         Log.i(TAG,"创建成功");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
