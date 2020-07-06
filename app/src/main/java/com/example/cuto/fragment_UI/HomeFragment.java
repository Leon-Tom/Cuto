package com.example.cuto.fragment_UI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.example.cuto.Adapter.HomeAdapter;
import com.example.cuto.R;

public class HomeFragment extends Fragment {

    private ImageView imageView;


    @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_home, container, false);

       // imageView = view.findViewById(R.id.list_view_home);

        return view;

    }
}
