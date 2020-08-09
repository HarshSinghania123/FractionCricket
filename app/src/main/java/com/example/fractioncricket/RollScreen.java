package com.example.fractioncricket;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class RollScreen extends AppCompatActivity {

    ImageButton btnBall, btnBat;
    ImageView questionImage;
    Intent intent;
    EditText dividendTxt, divisorTxt;
    int scoresCount = 0 , wicketsCount = 10;
    String result, dividend, divisor, imgNameStr  ;
    HashMap<String, List<String>> fractionMap;
    HashMap<String, List<String>> fractionMapCopy;
    Integer imageName[] = new Integer [6];
    List<Integer> randomizeArrayList;
    Integer randomTempNum [] = new Integer [6];
    Random rand;
    TextView scoreTxt, wicketTxt;
    Object tempObject ;

    int iterator = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roll_screen);
        btnBall = findViewById(R.id.imageButton_ball);
        btnBat = findViewById(R.id.imageButton_bat);
        scoreTxt = findViewById(R.id.score);
        wicketTxt = findViewById(R.id.wicket);
        iterator = 0;

        rand = new Random();
        fractionMap = new HashMap<>();
        fractionMapCopy = new HashMap<>();
        dividendTxt = findViewById(R.id.dividendText);
        divisorTxt = findViewById(R.id.divisorText);
        questionImage = findViewById(R.id.question_image);


//        ********************Random Set Generation****************
        for (int i = 0; i<6; i++){
            randomTempNum[i] = i+1;
        }

//        *************************Saving the results of the image in a hashmap*************
        fractionMap.put("img_1", Arrays.asList(new String[] {"1/5", "1/6", "2/5"}));
        fractionMap.put("img_2", Arrays.asList(new String[] {"2/5", "2/6", "1/3"}));
        fractionMap.put("img_3", Arrays.asList(new String[] {"4/5", "5/6", "3/5"}));
        fractionMap.put("img_4", Arrays.asList(new String[] {"1/3", "2/3"}));
        fractionMap.put("img_5", Arrays.asList(new String[] {"1/9", "1/7"}));
        fractionMap.put("img_6", Arrays.asList(new String[] {"5/4"}));
//        fractionMap.put("img_7", Arrays.asList(new String[] {"6/5"}));

//        *********************Image location storing array****************
        imageName[0]= R.drawable.img_1;
        imageName[1]= R.drawable.img_2;
        imageName[2]= R.drawable.img_3;
        imageName[3]= R.drawable.img_4;
        imageName[4]= R.drawable.img_5;
        imageName[5]= R.drawable.img_6;


//        ***************************Randamization of list*************************
        randomizeArrayList = Arrays.asList(randomTempNum);
        Collections.shuffle(randomizeArrayList);
        randomTempNum = randomizeArrayList.toArray(randomTempNum);


//      ******************* click event of BALL button*********************

        btnBall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgNameStr = "img_";

//                *************************Image Selection  ***************************
                questionImage.setImageResource(imageName[randomTempNum[iterator]-1]);
                imgNameStr = imgNameStr.concat(""+(randomTempNum[iterator]));
                btnBat.setVisibility(View.VISIBLE);
                btnBall.setVisibility(View.INVISIBLE);
            }
        });

//        *********************Click event of BAT button ********************
        btnBat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dividend = (dividendTxt.getText().toString());
                divisor = (divisorTxt.getText().toString());
                result = ""+dividend + "/" +divisor;


//                *********************Validation for Empty edits click event***********************
                if (!((dividend.isEmpty() && divisor.isEmpty() ) || (dividend.equals(" ") && divisor.equals(" ")))) {
                    intent = new Intent(getApplicationContext(), QuestionScreen.class);
                    if(fractionMap.get(imgNameStr).contains(result)) {
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
                    questionImage.setImageResource(R.drawable.ball_throwing);
                    imgNameStr = "";
                    result = "";
                    divisorTxt.setText("");
                    dividendTxt.setText("");
                }
                btnBat.setVisibility(View.INVISIBLE);
                btnBall.setVisibility(View.VISIBLE);
                if(iterator < 6){
                iterator++;}
            }
        });
//         *****************GAME OVER****************
//        if (wicketsCount == 0){
//
//        }
    }
}