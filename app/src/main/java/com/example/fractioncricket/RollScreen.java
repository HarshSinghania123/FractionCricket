package com.example.fractioncricket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import pl.droidsonroids.gif.GifImageView;

public class RollScreen extends AppCompatActivity {

//    GifImageView throwImg;
    ImageButton btnBall, btnBat;
    ImageView questionImage;
//    Animation mBounceAnimation;
    Intent intent;
    EditText dividendTxt, divisorTxt;
    int scoresCount = 0 , wicketsCount = 10;
    String result, dividend, divisor, imgName  ;
    HashMap<String, List<String>> fractionMap;
    HashMap<String, List<String>> fractionMapCopy;
    int imageName[] = new int [7];
    Random rand;
    TextView scoreTxt, wicketTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roll_screen);
        btnBall = findViewById(R.id.imageButton_ball);
        btnBat = findViewById(R.id.imageButton_bat);
        scoreTxt = findViewById(R.id.score);
        wicketTxt = findViewById(R.id.wicket);

        rand = new Random();
        fractionMap = new HashMap<>();
        fractionMapCopy = new HashMap<>();
        dividendTxt = findViewById(R.id.dividendText);
        divisorTxt = findViewById(R.id.divisorText);
        questionImage = findViewById(R.id.question_image);
        fractionMap.put("img_1", Arrays.asList(new String[] {"1/5", "1/6", "2/5"}));
        fractionMap.put("img_2", Arrays.asList(new String[] {"2/5", "2/6", "1/3"}));
        fractionMap.put("img_3", Arrays.asList(new String[] {"4/5", "5/6", "3/5"}));
        fractionMap.put("img_4", Arrays.asList(new String[] {"1/3", "2/3"}));
        fractionMap.put("img_5", Arrays.asList(new String[] {"1/9", "1/7"}));
        fractionMap.put("img_6", Arrays.asList(new String[] {"5/4"}));
//        fractionMap.put("img_7", Arrays.asList(new String[] {"6/5"}));

        imageName[0]= R.drawable.img_1;
        imageName[1]= R.drawable.img_2;
        imageName[2]= R.drawable.img_3;
        imageName[3]= R.drawable.img_4;
        imageName[4]= R.drawable.img_5;
        imageName[5]= R.drawable.img_6;

//        Creating a copy of the original map for processing

        fractionMapCopy = fractionMap;

//

        btnBall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgName = "img_";
//                dividendTxt.setEnabled(true);
//                divisorTxt.setEnabled(true);
                //btnBall.setVisibility(View.INVISIBLE);
//                btnBat.setVisibility(View.VISIBLE);

//                Image Selection
                int randomImage = (rand.nextInt(6)); //modulo with the no of images given to get the number within the range and start wwith the index 1
                questionImage.setImageResource(imageName[randomImage]); // obtaining the particular image for the based on the above number
                imgName = imgName.concat(""+(randomImage+1));
                Toast.makeText(getApplicationContext(), imgName, Toast.LENGTH_LONG).show();
            }
        });

        btnBat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dividend = (dividendTxt.getText().toString());
                divisor = (divisorTxt.getText().toString());
                result = ""+dividend + "/" +divisor;
                divisorTxt.setText("");
                dividendTxt.setText("");

                intent = new Intent(getApplicationContext(), QuestionScreen.class);
                if(fractionMap.get(imgName).contains(result)) {
                    intent.putExtra("result", "win");
                    scoresCount += 6;
                    scoreTxt.setText(""+scoresCount);


                }
                else{
                    intent.putExtra("result","out");
                    wicketsCount -= 1;
                    wicketTxt.setText(""+wicketsCount);
                }
                startActivity(intent);
            }
        });
//         *****************GAME OVER****************
//        if (wicketsCount == 0){
//
//        }
    }
}