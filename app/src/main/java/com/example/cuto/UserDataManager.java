package com.example.cuto;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class UserDataManager {


    private static final String TAG = "UserDataManager";
    private static final String DB_NAME = "user_data";
    private static final String TABLE_NAME = "users";
    public static final String ID = "_id";
    public static final String USER_NAME = "user_name";
    public static final String USER_PWD = "user_pawd";
    private static final int DB_VERSION = 1;
    private Context mContext = null;
    private DataBaseManagementHelper dataBaseManagementHelper = null;
    private SQLiteDatabase sqLiteDatabase = null;


    //创建用户book表
    private static final String DB_CREATE = "CREATE TABLE " + TABLE_NAME + "("+ ID + " integer primary key," + USER_NAME + " varchar,"
            + USER_PWD + " varchar" + ");";


    public UserDataManager(Context context) {
        mContext = context;
        Log.i(TAG, "UserDataManager construction!");
    }




    //创建数据库
    private static class DataBaseManagementHelper extends SQLiteOpenHelper{

        DataBaseManagementHelper(Context context){
            super(context,DB_NAME,null,DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            Log.i(TAG,"创建数据库表");
            sqLiteDatabase.execSQL(DB_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }

        @Override
        public void onOpen(SQLiteDatabase sqLiteDatabase) {
            super.onOpen(sqLiteDatabase);
        }
    }
    //打开数据库
    public void openDataBase() throws SQLException{
        dataBaseManagementHelper = new DataBaseManagementHelper(mContext);
        sqLiteDatabase = dataBaseManagementHelper.getWritableDatabase();
    }

    //关闭数据库
    public void closeDataBase()throws SQLException{
        sqLiteDatabase.close();
    }

    //添加用户（注册）
    public long addUser(UserData userData){
        String username = userData.getUserName();
        String userpawd = userData.getUserPwad();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USER_NAME,username);
        contentValues.put(USER_PWD,userpawd);
        return sqLiteDatabase.insert(TABLE_NAME,ID,contentValues);
    }
}
