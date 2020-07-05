package com.example.cuto.fragment_UI;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.cuto.MainActivity;
import com.example.cuto.R;

public class ClassifyFragment extends Fragment {

    private EditText editText;
    private Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.frag_classify,container,false);

        editText = view.findViewById(R.id.classify_input);
        button = view.findViewById(R.id.classify_btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = editText.getText().toString().trim();

                Toast.makeText(getActivity().getApplicationContext(), input, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

}
