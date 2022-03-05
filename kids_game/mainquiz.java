package com.example.kids_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Random;

public class mainquiz extends AppCompatActivity {
    private TextView questionIv, questionNumIv;
    private Button option1btn, option2btn, option3btn, option4btn;
    private ArrayList<QuizModel> quizModelArrayList;
    Random random ;
    int currentscore = 1 , quizattempted =1 , correctPos ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainquiz);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        questionIv = findViewById(R.id.qs);
        questionNumIv = findViewById(R.id.qsNum);
        option1btn = findViewById(R.id.option1);
        option2btn = findViewById(R.id.option2);
        option3btn = findViewById(R.id.option3);
        option4btn = findViewById(R.id.option4);
        quizModelArrayList = new ArrayList<>();
        random = new Random();
        getQuizQuestion(quizModelArrayList);
        correctPos = random.nextInt(quizModelArrayList.size());
        setDataToviews(correctPos);
        option1btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(option1btn.getText() == quizModelArrayList.get(correctPos).getAnswer())
                {
                    currentscore++;
                }
                quizattempted++;
                correctPos =   random.nextInt(quizModelArrayList.size());
                setDataToviews(correctPos);
            }
        });
        option2btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(option2btn.getText() == quizModelArrayList.get(correctPos).getAnswer())
                {
                    currentscore++;
                }
                quizattempted++;
                correctPos =   random.nextInt(quizModelArrayList.size());
                setDataToviews(correctPos);
            }
        });
        option3btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(option3btn.getText() == quizModelArrayList.get(correctPos).getAnswer())
                {
                    currentscore++;
                }
                quizattempted++;
                correctPos =   random.nextInt(quizModelArrayList.size());
                setDataToviews(correctPos);
            }
        });
        option4btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(option4btn.getText() == quizModelArrayList.get(correctPos).getAnswer())
                {
                    currentscore++;
                }
                quizattempted++;
                correctPos =   random.nextInt(quizModelArrayList.size());
                setDataToviews(correctPos);
            }
        });

    }
    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(mainquiz.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.scoreboard,(LinearLayout)findViewById(R.id.scorelayout));
        TextView scoreboard = bottomSheetView.findViewById(R.id.ivscore);
        Button restartQuizBtn = bottomSheetView.findViewById(R.id.btnRestart);
        scoreboard.setText("Your Score is " + currentscore + "/10");
        restartQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                correctPos = random.nextInt(quizModelArrayList.size());
                setDataToviews(correctPos);
                quizattempted = 1;
                currentscore = 0;
                bottomSheetDialog.dismiss();

            }
        });
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();

    }

    private void setDataToviews(int correctPos) {
        questionNumIv.setText("Question Attempted :" + quizattempted+ "/10");
        if(quizattempted==10)
        {
            showBottomSheet();
        }
        else
        {
            questionIv.setText(quizModelArrayList.get(correctPos).getQuestion());
            option1btn.setText(quizModelArrayList.get(correctPos).getOption1());
            option2btn.setText(quizModelArrayList.get(correctPos).getOption2());
            option3btn.setText(quizModelArrayList.get(correctPos).getOption3());
            option4btn.setText(quizModelArrayList.get(correctPos).getOption4());}
    }

    private void getQuizQuestion(ArrayList<QuizModel>quizModelArrayList) {
        quizModelArrayList.add(new QuizModel("which one is Alphabet A", "Aa" , "Bb" , "Cc" , "Dd" , "Aa"));
        quizModelArrayList.add(new QuizModel("which one is Alphabet B", "Aa" , "Bb" , "Cc" , "Dd" , "Bb"));
        quizModelArrayList.add(new QuizModel("which one is Alphabet C", "Aa" , "Bb" , "Cc" , "Dd" , "Cc"));
        quizModelArrayList.add(new QuizModel("which one is Alphabet D", "Aa" , "Bb" , "Cc" , "Dd" , "Dd"));
        quizModelArrayList.add(new QuizModel("which one is Alphabet E", "Aa" , "Bb" , "Ee" , "Dd" , "Ee"));
        quizModelArrayList.add(new QuizModel("which one is Alphabet F", "Aa" , "Bb" , "Ff" , "Dd" , "Ff"));
        quizModelArrayList.add(new QuizModel("which one is Alphabet G", "Aa" , "Gg" , "Cc" , "Hh" , "Gg"));
        quizModelArrayList.add(new QuizModel("which one is Alphabet H", "Hh" , "Ii" , "Gg" , "Kk" , "Hh"));
        quizModelArrayList.add(new QuizModel("which one is Alphabet I", "Aa" , "Bb" , "Cc" , "Ii" , "Ii"));
        quizModelArrayList.add(new QuizModel("which one is Alphabet J", "Aa" , "Bb" , "Jj" , "Dd" , "Jj"));


    }
}