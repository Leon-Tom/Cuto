package com.example.cuto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private UserDataManage userDataManage;
    private SQLiteDatabase db;
    private static final String TAG = "LoginActivity";


    private Button button_loginTo;
    private Button button_signTo;

    private EditText editText_username;
    private EditText editText_userpwad;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editText_username = (EditText)findViewById(R.id.ed_username);
        editText_userpwad = (EditText)findViewById(R.id.ed_userpawd);

        button_loginTo = (Button)findViewById(R.id.btn_login);
        button_signTo = (Button)findViewById(R.id.btn_tosigin);

        button_loginTo.setOnClickListener(this);
        button_signTo.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){

            //跳转主页
            case R.id.btn_login:
                if (isUserNameAndPwdValid()){
                    login();
                }
                break;

            //跳转注册
            case R.id.btn_tosigin:
                register();
                break;
        }
    }

    //判断输入
    public boolean isUserNameAndPwdValid() {
        if (editText_username.getText().toString().trim().equals("")) {
            Toast.makeText(this,"用户名不能为空", Toast.LENGTH_SHORT).show();
            return false;
        } else if (editText_userpwad.getText().toString().trim().equals("")) {
            Toast.makeText(this,"密码不能为空", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    //登录
    private void login(){

        userDataManage = new UserDataManage(this);
        db = userDataManage.getReadableDatabase();

        String u_name = editText_username.getText().toString().trim();
        String u_pawd = editText_userpwad.getText().toString().trim();


        Cursor cursor = db.query("user_book", null, null, null, null, null, null);
        while (cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndex("user_name"));
            String pawd = cursor.getString(cursor.getColumnIndex("user_pawd"));
            if (name.equals(u_name)){
                if (pawd.equals(u_pawd)) {
                    Intent intent = new Intent(this, MainActivity.class);
                    intent.putExtra("name",u_name);
                    startActivity(intent);
                    this.finish();
                    break;
                }else{
                    Toast.makeText(this, "用户密码不正确", Toast.LENGTH_SHORT).show();
                    break;
                }
            }else{
                Toast.makeText(this, "用户名不正确", Toast.LENGTH_SHORT).show();
                Log.i(TAG,"");
                break;
            }
        }
        cursor.close();
        Log.i(TAG,"游标关闭");
        db.close();
        Log.i(TAG,"数据库关闭");
    }


    //注册
    private void register(){
            Intent intent_register = new Intent();
            intent_register.setAction("register_activity");
            intent_register.addCategory("register_category");
            startActivity(intent_register);
    }
}