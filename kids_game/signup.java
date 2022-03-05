package com.example.kids_game;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class signup extends Fragment {
    private Button signup;
    private EditText uname,uemail,pass;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.activity_signup, container, false);
        signup=root.findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uname=root.findViewById(R.id.name);
                uemail=root.findViewById(R.id.email);
                pass=root.findViewById(R.id.pass);
                String name=uname.getText().toString().trim();
                String email=uemail.getText().toString().trim();
                String password=pass.getText().toString().trim();
                ((loginmain) getActivity()).adduser(name,email,password);


            }
        });
        return root;
    }


}