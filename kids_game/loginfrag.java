package com.example.kids_game;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class loginfrag extends Fragment {
    EditText uemail , pass;
    TextView forgetpass;
    Button login;
    float v=0;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.activity_loginfrag, container, false);
login=root.findViewById(R.id.login);
    login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                uemail=root.findViewById(R.id.email);
                pass=root.findViewById(R.id.pass);
                String email=uemail.getText().toString().trim();
                String password=pass.getText().toString().trim();
                ((loginmain) getActivity()).login(email,password);

            }
        });
        uemail = root.findViewById(R.id.email);
        pass = root.findViewById(R.id.pass);
        forgetpass= root.findViewById(R.id.forget);
        login = root.findViewById(R.id.login);

        uemail.setTranslationX(800);
        pass.setTranslationX(800);
        forgetpass.setTranslationX(800);
        login.setTranslationX(800);


        uemail.setAlpha(v);
        pass.setAlpha(v);
        forgetpass.setAlpha(v);
        login.setAlpha(v);

        uemail.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        pass.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        forgetpass.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        login.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();
        return root;
    }
}