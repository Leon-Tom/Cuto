package com.example.cuto;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;


public class UserDataManage extends SQLiteOpenHelper {

    private static final String TAG = "UserDataManage";
    private static final String DB_NAME = "user_data";
    private static final int VERSION = 1;//数据库版本号

    private Context context;



    public UserDataManage(Context context) {
        super(context, "user_data", null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
         String sql = "create table user_book(_id integer primary key autoincrement, user_name varchar(20),user_pawd varchar(20),user_email varchar(20))";
         db.execSQL("drop table if exists user_book");
         db.execSQL(sql);
         Log.i(TAG,"表创建成功");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addUserManager(SQLiteDatabase db ,String name, String pawd,String email){

        ContentValues contentValues = new ContentValues();
        contentValues.put("user_name",name);
        contentValues.put("user_pawd",pawd);
        contentValues.put("user_email",email);
        db.insert("user_book",null,contentValues);
    }

//    public ArrayList<UserData> getAllData(){//将表内信息返回成一个list
//
//        ArrayList<UserData> list = new ArrayList<UserData>();
//        Cursor cursor = sqLiteDatabase.query("user_book",null,null,null,null,null,"name DESC");//1表名，2列，3行，4行，5指定列进行过滤，6进一步过滤。7得到的信息进行排序（desc逆序）
//        while(cursor.moveToNext()){//一行一行遍历
//
//            String name = cursor.getString(cursor.getColumnIndex("user_name"));//移动到name列，读取出来
//            String password = cursor.getString(cursor.getColumnIndex("user_pawd"));
//            String email = cursor.getString(cursor.getColumnIndex("user_email"));
//            list.add(new UserData(name,password,email));//添加到user 的list中
//
//        }
//        return list;  //把list返回
//    }

}
