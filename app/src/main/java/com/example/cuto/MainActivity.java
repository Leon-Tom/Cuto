package com.example.cuto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.cuto.fragment_UI.ClassifyFragment;
import com.example.cuto.fragment_UI.HomeFragment;
import com.example.cuto.fragment_UI.UserFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 首页
     *
     * */


    private ImageButton imageButton_1,imageButton_2,imageButton_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageButton_1 = findViewById(R.id.btn_sy);
        imageButton_2 = findViewById(R.id.btn_fl);
        imageButton_3 =findViewById(R.id.btn_gr);

        imageButton_1.setOnClickListener(this);
        imageButton_2.setOnClickListener(this);
        imageButton_3.setOnClickListener(this);
        initFragment();




    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_sy:
                initFragment();
                break;

            case R.id.btn_fl:
                ClassifyFragment classifyFragment = new ClassifyFragment();
                FragmentManager fragmentManager_2 = getSupportFragmentManager();
                FragmentTransaction ft_2 = fragmentManager_2.beginTransaction();
                ft_2.replace(R.id.frag_view,classifyFragment);
                ft_2.commit();
                break;

            case R.id.btn_gr:
                UserFragment userFragment = new UserFragment();
                FragmentManager fragmentManager_3 = getSupportFragmentManager();
                FragmentTransaction ft_3 = fragmentManager_3.beginTransaction();
                ft_3.replace(R.id.frag_view,userFragment);
                ft_3.commit();
                break;
        }
    }


    //加载首页的方法，用于初始化首页
    public void initFragment(){
        HomeFragment homeFragment = new HomeFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft_1 = fragmentManager.beginTransaction();
        ft_1.replace(R.id.frag_view,homeFragment);
        ft_1.commit();
    }
}


/**
 * z流星雨
 *
 */

