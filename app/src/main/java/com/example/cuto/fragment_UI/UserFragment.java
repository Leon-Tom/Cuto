package com.example.cuto.fragment_UI;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.cuto.LoginActivity;
import com.example.cuto.R;

public class UserFragment extends Fragment implements View.OnClickListener {

    private Button button_break,button_zuozhe;
    private TextView editText_name;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.frag_user,container,false);

        editText_name = view.findViewById(R.id.text_view_username);

        button_break = view.findViewById(R.id.user_btn_break);
        button_zuozhe = view.findViewById(R.id.btn_zuozhe);

        button_break.setOnClickListener(this);
        button_zuozhe.setOnClickListener(this);

        Intent intent = getActivity().getIntent();
        String uName = intent.getStringExtra("name");
        editText_name.setText(uName);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.user_btn_break:
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                getActivity().finish();
                break;

            case R.id.btn_zuozhe:


                break;
        }
    }
}
