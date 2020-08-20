package com.example.fractioncricket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameModeSelection extends AppCompatActivity {

    Intent intent;
    Button easyBtnClick, hardBtnClick;
    MediaPlayer btnClkSnd;
    private static final int GAMEMODE_ACTIVITY_REQUEST_CODE = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_mode_selection);

        easyBtnClick = findViewById(R.id.button_easy);
        hardBtnClick = findViewById(R.id.button_hard);
        btnClkSnd = MediaPlayer.create(GameModeSelection.this, R.raw.all_btn_clk_snd);
        easyBtnClick.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                btnClkSnd.start();
                intent = new Intent(getApplicationContext(), RollScreen.class);
                intent.putExtra("mode", "easy");
                startActivityForResult(intent, GAMEMODE_ACTIVITY_REQUEST_CODE);
            }
        });

        hardBtnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnClkSnd.start();
                intent = new Intent(getApplicationContext(), RollScreen.class);
                intent.putExtra("mode", "hard");
                startActivityForResult(intent, GAMEMODE_ACTIVITY_REQUEST_CODE);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if(requestCode == GAMEMODE_ACTIVITY_REQUEST_CODE){
            if(resultCode == RESULT_OK){
                finish();
                btnClkSnd.stop();
            }
        }
    }
}