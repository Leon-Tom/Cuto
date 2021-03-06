package com.example.cuto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {


    /***
     * 注册页面
     */


    private static final String TAG = "RegisterActivity";
    private EditText eT_re_userName;
    private EditText eT_re_userPawd;
    private EditText eT_re_userEmail;
    private Button bT_regist;
    private Button bT_regist_to_break;
    private UserDataManage userDataManage;
    private SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }


    //初始化控件
    private void initView(){

        eT_re_userName = findViewById(R.id.ed_username_sigin);
        eT_re_userPawd = findViewById(R.id.ed_userpawd_sigin);
        eT_re_userEmail = findViewById(R.id.ed_email_sigin);
        bT_regist = findViewById(R.id.btn_register);
        bT_regist_to_break = findViewById(R.id.btn_break);

        bT_regist.setOnClickListener(this);
        bT_regist_to_break.setOnClickListener(this);

        if (userDataManage == null){
            userDataManage = new UserDataManage(this);
        }


    }

    @Override
    public void onClick(View v) {
        String TAG = "ok";
        switch (v.getId()){
            //注册
            case R.id.btn_register:
                if(isUnameAndUpwdAndUem()){
                    regist();
                }
                break;

            //返回登录
            case R.id.btn_break:
                breakTologin();
                Log.i(TAG,"点击");
                break;
        }

    }

    //返回登录页面
    private void breakTologin(){
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
        this.finish();
    }

    //判断输入
    private boolean isUnameAndUpwdAndUem(){
        if (eT_re_userName.getText().toString().trim().equals("")){
            Toast.makeText(this, "用户名不能为空", Toast.LENGTH_SHORT).show();
            return false;
        }else if (eT_re_userPawd.getText().toString().trim().equals("")){
            Toast.makeText(this, "用户密码不能为空", Toast.LENGTH_SHORT).show();
            return false;
        }else if (eT_re_userEmail.getText().toString().trim().equals("")){
            Toast.makeText(this, "用户邮箱不能为空", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true; //返回true表示不为空
    }

    //注册
    private void regist(){

        String u_name = eT_re_userName.getText().toString().trim();
        String u_pawd = eT_re_userPawd.getText().toString().trim();
        String u_email = eT_re_userEmail.getText().toString().trim();

        userDataManage = new UserDataManage(this);
        SQLiteDatabase db = userDataManage.getWritableDatabase();//建立打开可读写的数据库实例
        Log.i(TAG,"数据库开启成功");

        userDataManage.addUserManager(db, u_name, u_pawd, u_email);
        Log.i(TAG, "写入成功");
        Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
        breakTologin();


        Cursor cursor = db.query("user_book", null, null,
                null, null, null, null);
        Log.i(TAG,"游标建立成功");

        // rawQuerySql = "select * from "+TABLE_NAME_PERSON+" where "+VALUE_NAME +" = ?"+" and "+ VALUE_AGE +" > ?";
        //        cursor = getWritableDatabase().rawQuery(rawQuerySql,new String[]{"张三","23"});
        //        Cursor cursor = db.query("user_book",new String[]{"user_name"},
        //                null,null,null,null,null);  //差点被这个函数折磨死掉

        //String sql = "select user_name from user_book where user_name=?";
        while (cursor.moveToNext()){
            Log.i(TAG,"进入循环");
           String name = cursor.getString(cursor.getColumnIndex("user_name")).trim();

           if(name.equals(u_name)){
               Log.i(TAG,"进入判断1");
               Toast.makeText(this, "用户已存在", Toast.LENGTH_SHORT).show();
               Intent intent = new Intent(this, LoginActivity.class);
               startActivity(intent);
               break;
           }else{
               Log.i(TAG,"写入");
               userDataManage.addUserManager(db, u_name, u_pawd, u_email);
               Log.i(TAG, "写入成功");
               Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
               breakTologin();
               break;
           }

       }
        cursor.close();
        Log.i(TAG,"游标关闭成功");
        db.close();
        Log.i(TAG,"数据库关闭成功");
    }

}