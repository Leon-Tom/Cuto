package com.example.cuto.fragment_UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.cuto.Adapter.Home;
import com.example.cuto.Adapter.HomeAdapter;
import com.example.cuto.DetailedImg;
import com.example.cuto.R;

public class HomeFragment extends Fragment {

    private ListView listView;
    private int[] imageId = {R.drawable.img_7, R.drawable.img_2, R.drawable.img_3, R.drawable.img_5,};


    @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_home, container, false);
        listView = view.findViewById(R.id.list_view_home);
        final HomeAdapter homeAdapter = new HomeAdapter(getContext(),imageId);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                /**
                 需要写一个将该ListView的图片路径传到DetailedImg的方法
                 */

                Toast.makeText(getContext(), "点击", Toast.LENGTH_SHORT).show();
            }
        });

        listView.setVerticalScrollBarEnabled(false);
        listView.setAdapter(homeAdapter);
        return view;
    }

}
