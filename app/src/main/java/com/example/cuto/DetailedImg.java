package com.example.cuto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class DetailedImg extends AppCompatActivity implements View.OnClickListener {
    /**
     * 显示一张用户具体点击的图片 为其展示全图
     */



    private Button button_hold;
    private Button button_setWP;
    private Button button_outTo;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_img);
        initView();

    }

    private void initView(){

        imageView = findViewById(R.id.detailed_img_view);
        button_hold = findViewById(R.id.detailed_btn_hold);
        button_setWP = findViewById(R.id.detailed_btn_setWP);
        button_outTo = findViewById(R.id.detailed_btn_outTo);

        button_hold.setOnClickListener(this);
        button_setWP.setOnClickListener(this);
        button_outTo.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.detailed_btn_hold:
                setHold();
                break;

            case R.id.detailed_btn_setWP:
                setWallpaper(R.drawable.img_2);
                break;

            case R.id.detailed_btn_outTo:
                outTohome();
                break;
        }

    }

    //保存到相册
    private void setHold(){

    }

    //直接设置成壁纸
    private void setWallpaper(int imageId){
            try{
                this.clearWallpaper();
                this.setWallpaper(getResources().openRawResource(imageId));
                Toast.makeText(this, "设置成功 请返回桌面查看", Toast.LENGTH_SHORT).show();
            }catch (Exception e){
                e.printStackTrace();
            }

    }

    //返回到主界面
    private void outTohome(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        this.finish();
    }
}