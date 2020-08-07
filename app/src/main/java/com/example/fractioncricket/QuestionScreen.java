package com.example.fractioncricket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import pl.droidsonroids.gif.GifImageView;

public class QuestionScreen extends AppCompatActivity {

    GifImageView statusGif;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_screen);
        statusGif = findViewById(R.id.result_gif);
        String status = getIntent().getExtras().getString("result");
        if(status.equalsIgnoreCase("win")){
            statusGif.setImageResource(R.drawable.win);
        }
        else if (status.equalsIgnoreCase("out")){
            statusGif.setImageResource(R.drawable.out);
        }

//        try {
//            Thread.sleep(9000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        this.finish();

        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            public void run() {
                finish();
            }
        }, 3000);
    }
}