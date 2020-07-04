package com.example.cuto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText eT_re_userName;
    private EditText eT_re_userPawd;
    private EditText eT_re_userEmail;

    private Button bT_regist;
    private Button bT_regist_to_break;
    private UserDAO userDAO;
    private Context context;

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

        if (userDAO == null){
            userDAO = new UserDAO(context);
        }
    }




    @Override
    public void onClick(View v) {
        String TAG = "ok";
        switch (v.getId()){
            //注册
            case R.id.btn_register:
                if(isUnameAndUpwdAndUem()){
                    isToRegister();
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

    //检测用户名存在情况
    private void isToRegister(){
        String username = eT_re_userName.getText().toString().trim();
        String userpawd = eT_re_userPawd.getText().toString().trim();
        String useremail = eT_re_userEmail.getText().toString().trim();
        int count = userDAO.isByName(username);
        long flag = userDAO.userSubmit(username,userpawd);

        if (count>0){
            Toast.makeText(this, "用户已存在", Toast.LENGTH_SHORT).show();
            return ;
        }
        if (flag == -1){
            Toast.makeText(this, "注册失败", Toast.LENGTH_SHORT).show();
        }else{
            UserData userData = new UserData(username,userpawd,useremail);
            userDAO.addUser(userData);
            Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
            breakTologin();
            //userDAO.closeDataBase();
        }


    }


}