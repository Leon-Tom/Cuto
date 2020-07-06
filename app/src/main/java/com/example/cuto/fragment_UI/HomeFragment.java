package com.example.cuto.fragment_UI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.cuto.Adapter.HomeAdapter;
import com.example.cuto.R;

public class HomeFragment extends Fragment {

    private ImageView imageView;
    private ListView listView;

    private int[] imageId = {
            R.drawable.img_7,
            R.drawable.img_2,
            R.drawable.img_3,
            R.drawable.img_5,};


    @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_home, container, false);
        listView = view.findViewById(R.id.list_view_home);
        HomeAdapter homeAdapter = new HomeAdapter(getContext(),imageId);
        listView.setVerticalScrollBarEnabled(false);
        listView.setAdapter(homeAdapter);
        return view;
    }

}
