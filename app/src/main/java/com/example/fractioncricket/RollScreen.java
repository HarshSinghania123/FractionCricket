package com.example.fractioncricket;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import pl.droidsonroids.gif.GifImageView;

public class RollScreen extends AppCompatActivity {

    ImageButton btnBall, btnBat, btnClose;
    ImageView questionImage;
    Intent intent;
    EditText dividendTxt, divisorTxt;
    int scoresCount = 0 , wicketsCount = 5, limit = 0;
    String gameMode, result, dividend, divisor, imgNameStr  ;
    HashMap<String, List<String>> fractionMap;
    HashMap<String, List<String>> fractionMapCopy;
    Integer imageName[] = new Integer [46];
    List<Integer> randomizeArrayList;
    Random rand;
    TextView scoreTxt, wicketTxt, outCloseBtn, finishCloseBtn, slashTxt, crctAnsTxt;
    Object tempObject;
    Dialog finishDlg, wicketOutDlg;
    MediaPlayer batClickSound, ballClickSound, exitBtnClkSnd, outSnd, winSnd;

    int iterator = 0;

    TextView finalScoreTxt, finalWicketsTxt, outScoreTxt, outWicketsTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roll_screen);

        gameMode = getIntent().getExtras().getString("mode");

        btnBall = findViewById(R.id.imageButton_ball);
        btnBat = findViewById(R.id.imageButton_bat);
        scoreTxt = findViewById(R.id.score);
        wicketTxt = findViewById(R.id.wicket);
        slashTxt = findViewById(R.id.slash);
        btnClose = findViewById(R.id.imageButton_close);
        iterator = 0;

        rand = new Random();
        fractionMap = new HashMap<>();
        fractionMapCopy = new HashMap<>();
        dividendTxt = findViewById(R.id.dividendText);
        divisorTxt = findViewById(R.id.divisorText);
        questionImage = findViewById(R.id.question_image);
        randomizeArrayList = new ArrayList<Integer>();
        batClickSound = MediaPlayer.create(this,R.raw.bat_hit);
        ballClickSound = MediaPlayer.create(this,R.raw.ball_throw);
        exitBtnClkSnd = MediaPlayer.create(this,R.raw.exit_btn_clk);


//        *************************Saving the results of the image in a hashmap*************
        if(gameMode.equalsIgnoreCase("easy")) {
            limit = 46;
            for (int i = 0; i<limit; i++){
                randomizeArrayList.add(i+1);
            }
            fractionMap.put("easy_img_1", Arrays.asList(new String[]{"1/10"}));
            fractionMap.put("easy_img_2", Arrays.asList(new String[]{"2/10", "1/5"}));
            fractionMap.put("easy_img_3", Arrays.asList(new String[]{"3/10"}));
            fractionMap.put("easy_img_4", Arrays.asList(new String[]{"4/10", "2/5"}));
            fractionMap.put("easy_img_5", Arrays.asList(new String[]{"9/10"}));
            fractionMap.put("easy_img_6", Arrays.asList(new String[]{"10/10", "1/1"}));
            fractionMap.put("easy_img_7", Arrays.asList(new String[]{"3/9", "1/3"}));
            fractionMap.put("easy_img_8", Arrays.asList(new String[]{"4/9"}));
            fractionMap.put("easy_img_9", Arrays.asList(new String[]{"7/9"}));
            fractionMap.put("easy_img_10", Arrays.asList(new String[]{"8/9"}));
            fractionMap.put("easy_img_11", Arrays.asList(new String[]{"9/9", "1/1"}));
            fractionMap.put("easy_img_12", Arrays.asList(new String[]{"1/8"}));
            fractionMap.put("easy_img_13", Arrays.asList(new String[]{"2/8", "1/4"}));
            fractionMap.put("easy_img_14", Arrays.asList(new String[]{"3/8"}));
            fractionMap.put("easy_img_15", Arrays.asList(new String[]{"4/8", "1/2"}));
            fractionMap.put("easy_img_16", Arrays.asList(new String[]{"5/8"}));
            fractionMap.put("easy_img_17", Arrays.asList(new String[]{"1/1", "8/8"}));
            fractionMap.put("easy_img_18", Arrays.asList(new String[]{"1/7"}));
            fractionMap.put("easy_img_19", Arrays.asList(new String[]{"2/7"}));
            fractionMap.put("easy_img_20", Arrays.asList(new String[]{"3/7"}));
            fractionMap.put("easy_img_21", Arrays.asList(new String[]{"4/7"}));
            fractionMap.put("easy_img_22", Arrays.asList(new String[]{"5/7"}));
            fractionMap.put("easy_img_23", Arrays.asList(new String[]{"6/7"}));
            fractionMap.put("easy_img_24", Arrays.asList(new String[]{"7/7", "1/1"}));
            fractionMap.put("easy_img_25", Arrays.asList(new String[]{"1/6"}));
            fractionMap.put("easy_img_26", Arrays.asList(new String[]{"2/6", "1/3"}));
            fractionMap.put("easy_img_27", Arrays.asList(new String[]{"3/6", "1/2"}));
            fractionMap.put("easy_img_28", Arrays.asList(new String[]{"4/6", "2/3"}));
            fractionMap.put("easy_img_29", Arrays.asList(new String[]{"5/6"}));
            fractionMap.put("easy_img_30", Arrays.asList(new String[]{"1/1", "6/6"}));
            fractionMap.put("easy_img_31", Arrays.asList(new String[]{"1/5"}));
            fractionMap.put("easy_img_32", Arrays.asList(new String[]{"3/5"}));
            fractionMap.put("easy_img_33", Arrays.asList(new String[]{"2/5"}));
            fractionMap.put("easy_img_34", Arrays.asList(new String[]{"4/5"}));
            fractionMap.put("easy_img_35", Arrays.asList(new String[]{"1/4"}));
            fractionMap.put("easy_img_36", Arrays.asList(new String[]{"3/4"}));
            fractionMap.put("easy_img_37", Arrays.asList(new String[]{"5/5", "1/1"}));
            fractionMap.put("easy_img_38", Arrays.asList(new String[]{"1/2", "2/4"}));
            fractionMap.put("easy_img_39", Arrays.asList(new String[]{"1/3"}));
            fractionMap.put("easy_img_40", Arrays.asList(new String[]{"3/3", "1/1"}));
            fractionMap.put("easy_img_41", Arrays.asList(new String[]{"4/4", "1/1"}));
            fractionMap.put("easy_img_42", Arrays.asList(new String[]{"2/3"}));
            fractionMap.put("easy_img_43", Arrays.asList(new String[]{"1/2"}));
            fractionMap.put("easy_img_44", Arrays.asList(new String[]{"1/2"}));
            fractionMap.put("easy_img_45", Arrays.asList(new String[]{"2/2", "1/1"}));
            fractionMap.put("easy_img_46", Arrays.asList(new String[]{"1/1"}));

//        *********************Image location storing array****************
            imageName[0] = R.drawable.easy_img_1;
            imageName[1] = R.drawable.easy_img_2;
            imageName[2] = R.drawable.easy_img_3;
            imageName[3] = R.drawable.easy_img_4;
            imageName[4] = R.drawable.easy_img_5;
            imageName[5] = R.drawable.easy_img_6;
            imageName[6] = R.drawable.easy_img_7;
            imageName[7] = R.drawable.easy_img_8;
            imageName[8] = R.drawable.easy_img_9;
            imageName[9] = R.drawable.easy_img_10;
            imageName[10] = R.drawable.easy_img_11;
            imageName[11] = R.drawable.easy_img_12;
            imageName[12] = R.drawable.easy_img_13;
            imageName[13] = R.drawable.easy_img_14;
            imageName[14] = R.drawable.easy_img_15;
            imageName[15] = R.drawable.easy_img_16;
            imageName[16] = R.drawable.easy_img_17;
            imageName[17] = R.drawable.easy_img_18;
            imageName[18] = R.drawable.easy_img_19;
            imageName[19] = R.drawable.easy_img_20;
            imageName[20] = R.drawable.easy_img_21;
            imageName[21] = R.drawable.easy_img_22;
            imageName[22] = R.drawable.easy_img_23;
            imageName[23] = R.drawable.easy_img_24;
            imageName[24] = R.drawable.easy_img_25;
            imageName[25] = R.drawable.easy_img_26;
            imageName[26] = R.drawable.easy_img_27;
            imageName[27] = R.drawable.easy_img_28;
            imageName[28] = R.drawable.easy_img_29;
            imageName[29] = R.drawable.easy_img_30;
            imageName[30] = R.drawable.easy_img_31;
            imageName[31] = R.drawable.easy_img_32;
            imageName[32] = R.drawable.easy_img_33;
            imageName[33] = R.drawable.easy_img_34;
            imageName[34] = R.drawable.easy_img_35;
            imageName[35] = R.drawable.easy_img_36;
            imageName[36] = R.drawable.easy_img_37;
            imageName[37] = R.drawable.easy_img_38;
            imageName[38] = R.drawable.easy_img_39;
            imageName[39] = R.drawable.easy_img_40;
            imageName[40] = R.drawable.easy_img_41;
            imageName[41] = R.drawable.easy_img_42;
            imageName[42] = R.drawable.easy_img_43;
            imageName[43] = R.drawable.easy_img_44;
            imageName[44] = R.drawable.easy_img_45;
            imageName[45] = R.drawable.easy_img_46;
        }

        if(gameMode.equalsIgnoreCase("hard")) {
            limit = 36;
            for (int i = 0; i<limit; i++){
                randomizeArrayList.add(i+1);
            }
            fractionMap.put("hard_img_1", Arrays.asList(new String[]{"1/2"}));
            fractionMap.put("hard_img_2", Arrays.asList(new String[]{"5/8"}));
            fractionMap.put("hard_img_3", Arrays.asList(new String[]{"3/4"}));
            fractionMap.put("hard_img_4", Arrays.asList(new String[]{"3/4"}));
            fractionMap.put("hard_img_5", Arrays.asList(new String[]{"11/16"}));
            fractionMap.put("hard_img_6", Arrays.asList(new String[]{"7/16"}));
            fractionMap.put("hard_img_7", Arrays.asList(new String[]{"1/2"}));
            fractionMap.put("hard_img_8", Arrays.asList(new String[]{"5/8"}));
            fractionMap.put("hard_img_9", Arrays.asList(new String[]{"5/8"}));
            fractionMap.put("hard_img_10", Arrays.asList(new String[]{"1/2"}));
            fractionMap.put("hard_img_11", Arrays.asList(new String[]{"7/16"}));
            fractionMap.put("hard_img_12", Arrays.asList(new String[]{"1/2"}));
            fractionMap.put("hard_img_13", Arrays.asList(new String[]{"3/8"}));
            fractionMap.put("hard_img_14", Arrays.asList(new String[]{"3/4"}));
            fractionMap.put("hard_img_15", Arrays.asList(new String[]{"3/8"}));
            fractionMap.put("hard_img_16", Arrays.asList(new String[]{"1/4"}));
            fractionMap.put("hard_img_17", Arrays.asList(new String[]{"5/8"}));
            fractionMap.put("hard_img_18", Arrays.asList(new String[]{"1/2"}));
            fractionMap.put("hard_img_19", Arrays.asList(new String[]{"3/8"}));
            fractionMap.put("hard_img_20", Arrays.asList(new String[]{"1/2"}));
            fractionMap.put("hard_img_21", Arrays.asList(new String[]{"3/8"}));
            fractionMap.put("hard_img_22", Arrays.asList(new String[]{"21/32"}));
            fractionMap.put("hard_img_23", Arrays.asList(new String[]{"3/8"}));
            fractionMap.put("hard_img_24", Arrays.asList(new String[]{"3/4"}));
            fractionMap.put("hard_img_25", Arrays.asList(new String[]{"3/8"}));
            fractionMap.put("hard_img_26", Arrays.asList(new String[]{"3/16"}));
            fractionMap.put("hard_img_27", Arrays.asList(new String[]{"5/8"}));
            fractionMap.put("hard_img_28", Arrays.asList(new String[]{"1/2"}));
            fractionMap.put("hard_img_29", Arrays.asList(new String[]{"15/32"}));
            fractionMap.put("hard_img_30", Arrays.asList(new String[]{"9/16"}));
            fractionMap.put("hard_img_31", Arrays.asList(new String[]{"1/2"}));
            fractionMap.put("hard_img_32", Arrays.asList(new String[]{"1/4"}));
            fractionMap.put("hard_img_33", Arrays.asList(new String[]{"1/4"}));
            fractionMap.put("hard_img_34", Arrays.asList(new String[]{"1/2"}));
            fractionMap.put("hard_img_35", Arrays.asList(new String[]{"7/16"}));
            fractionMap.put("hard_img_36", Arrays.asList(new String[]{"1/2"}));

//        *********************Image location storing array****************
            imageName[0] = R.drawable.hard_img_1;
            imageName[1] = R.drawable.hard_img_2;
            imageName[2] = R.drawable.hard_img_3;
            imageName[3] = R.drawable.hard_img_4;
            imageName[4] = R.drawable.hard_img_5;
            imageName[5] = R.drawable.hard_img_6;
            imageName[6] = R.drawable.hard_img_7;
            imageName[7] = R.drawable.hard_img_8;
            imageName[8] = R.drawable.hard_img_9;
            imageName[9] = R.drawable.hard_img_10;
            imageName[10] = R.drawable.hard_img_11;
            imageName[11] = R.drawable.hard_img_12;
            imageName[12] = R.drawable.hard_img_13;
            imageName[13] = R.drawable.hard_img_14;
            imageName[14] = R.drawable.hard_img_15;
            imageName[15] = R.drawable.hard_img_16;
            imageName[16] = R.drawable.hard_img_17;
            imageName[17] = R.drawable.hard_img_18;
            imageName[18] = R.drawable.hard_img_19;
            imageName[19] = R.drawable.hard_img_20;
            imageName[20] = R.drawable.hard_img_21;
            imageName[21] = R.drawable.hard_img_22;
            imageName[22] = R.drawable.hard_img_23;
            imageName[23] = R.drawable.hard_img_24;
            imageName[24] = R.drawable.hard_img_25;
            imageName[25] = R.drawable.hard_img_26;
            imageName[26] = R.drawable.hard_img_27;
            imageName[27] = R.drawable.hard_img_28;
            imageName[28] = R.drawable.hard_img_29;
            imageName[29] = R.drawable.hard_img_30;
            imageName[30] = R.drawable.hard_img_31;
            imageName[31] = R.drawable.hard_img_32;
            imageName[32] = R.drawable.hard_img_33;
            imageName[33] = R.drawable.hard_img_34;
            imageName[34] = R.drawable.hard_img_35;
            imageName[35] = R.drawable.hard_img_36;
        }


//        ***************************Randamization of list*************************
        Collections.shuffle(randomizeArrayList);


//      ******************* click event of BALL button*********************

        btnBall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ballClickSound.start();
                if (gameMode.equalsIgnoreCase("easy")) {
                    imgNameStr = "easy_img_";
                }
                if (gameMode.equalsIgnoreCase("hard")) {
                    imgNameStr = "hard_img_";
                }

//                *************************Image Selection  ***************************
                questionImage.setImageResource(imageName[randomizeArrayList.get(iterator)-1]);
                imgNameStr = imgNameStr.concat(""+(randomizeArrayList.get(iterator)));
                btnBat.setVisibility(View.VISIBLE);
                slashTxt.setVisibility(View.VISIBLE);
                dividendTxt.setVisibility(View.VISIBLE);
                divisorTxt.setVisibility(View.VISIBLE);
                btnBall.setVisibility(View.INVISIBLE);
            }
        });

//        *********************Click event of BAT button ********************
        btnBat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                winSnd = MediaPlayer.create(RollScreen.this, R.raw.sixer_snd);
                outSnd = MediaPlayer.create(RollScreen.this, R.raw.out_snd);
                batClickSound.start();
                dividend = "";
                divisor = "";
                dividend = dividendTxt.getText().toString();
                divisor = divisorTxt.getText().toString();
                result = "" + dividend + "/" + divisor;


//                *********************Validation for Empty edits click event***********************
                if (!((dividend.isEmpty() || divisor.isEmpty()) || (dividend.equals(" ") || divisor.equals(" ")))) {
                    if (fractionMap.get(imgNameStr).contains(result)) {
                        scoresCount += 6;
                        scoreTxt.setText("" + scoresCount);

//                       *************************Sixer popup***************************
                        final Dialog winDlg = new Dialog(RollScreen.this);
                        winDlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
                        winDlg.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        winDlg.setOnDismissListener(new DialogInterface.OnDismissListener() {
                            @Override
                            public void onDismiss(DialogInterface dialogInterface) {
                                outSnd.reset();
                                winSnd.reset();
                                btnBall.setVisibility(View.VISIBLE);
                            }
                        });
                        GifImageView imageView = new GifImageView(RollScreen.this);
                        imageView.setImageResource(R.drawable.win);
                        winDlg.addContentView(imageView, new RelativeLayout.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT
                        ));
                        winDlg.show();
                        winSnd.start();

                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            public void run() {
                                winDlg.dismiss();
                                winSnd.reset();
                                outSnd.reset();
                            }
                        }, 3000);
                    } else {
                        wicketsCount -= 1;
                        wicketTxt.setText("" + (5 - wicketsCount));

//                        *********************Out popup*********************************
                        final Dialog outDlg = new Dialog(RollScreen.this);
                        outDlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
                        outDlg.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        outDlg.setOnDismissListener(new DialogInterface.OnDismissListener() {
                            @Override
                            public void onDismiss(DialogInterface dialogInterface) {
                                outSnd.reset();
                                winSnd.reset();
                                btnBall.setVisibility(View.VISIBLE);
//                                **************************GAME OVER*************************
                                if (wicketsCount == 0) {
                                    wicketOutDlg = new Dialog(RollScreen.this);
                                    wicketOutDlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
                                    wicketOutDlg.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                                    wicketOutDlg.setOnDismissListener(new DialogInterface.OnDismissListener() {
                                        @Override
                                        public void onDismiss(DialogInterface dialogInterface) {
                                            intent = new Intent();
                                            intent.putExtra("returnValue", "returned");
                                            setResult(RESULT_OK, intent);
                                            outSnd.reset();
                                            winSnd.reset();
                                            ballClickSound.stop();
                                            batClickSound.stop();
                                            finish();

                                        }
                                    });
                                    wicketOutDlg.setContentView(R.layout.activity_out_popup);
                                    outScoreTxt = wicketOutDlg.findViewById(R.id.out_score);
                                    outWicketsTxt = wicketOutDlg.findViewById(R.id.out_wickets);
                                    outCloseBtn = wicketOutDlg.findViewById(R.id.out_close);
                                    outCloseBtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            wicketOutDlg.dismiss();
                                        }
                                    });

                                    outScoreTxt.setText(scoreTxt.getText());
                                    outWicketsTxt.setText(wicketTxt.getText());
                                    wicketOutDlg.show();

                                }

                            }
                        });
                        outDlg.setContentView(R.layout.activity_wicket_out_screen);
                        crctAnsTxt = outDlg.findViewById(R.id.crctAnsTxt);
                        crctAnsTxt.setText(fractionMap.get(imgNameStr).toString());
                        outDlg.show();
                        outSnd.start();

                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            public void run() {
                                outDlg.dismiss();
                            }
                        }, 3000);
                    }
                    questionImage.setImageResource(0);
                    imgNameStr = "";
                    result = "";
                    divisorTxt.setText("");
                    dividendTxt.setText("");
                    btnBat.setVisibility(View.INVISIBLE);
                    slashTxt.setVisibility(View.INVISIBLE);
                    dividendTxt.setVisibility(View.INVISIBLE);
                    divisorTxt.setVisibility(View.INVISIBLE);
//                *************************When iterator exceeds the total image count***************
                    if (iterator < limit-1) {
                        iterator++;
                    } else {

                        finishDlg = new Dialog(RollScreen.this);
                        finishDlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
                        finishDlg.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        finishDlg.setOnDismissListener(new DialogInterface.OnDismissListener() {
                            @Override
                            public void onDismiss(DialogInterface dialogInterface) {
                                intent = new Intent();
                                intent.putExtra("returnValue", "returned");
                                setResult(RESULT_OK, intent);
                                outSnd.reset();
                                winSnd.reset();
                                ballClickSound.stop();
                                batClickSound.stop();
                                finish();


                            }
                        });
                        finishDlg.setContentView(R.layout.activity_finish_popup);
                        finalScoreTxt = finishDlg.findViewById(R.id.final_score);
                        finishCloseBtn = finishDlg.findViewById(R.id.finish_close);
                        finalWicketsTxt = finishDlg.findViewById(R.id.final_wickets);
                        finalScoreTxt.setText(scoreTxt.getText());
                        finalWicketsTxt.setText(wicketTxt.getText());
                        finishCloseBtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                finishDlg.dismiss();
                            }
                        });

                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            public void run() {
                                finishDlg.show();
                            }
                        }, 3000);
                    }
                }
            }
        });

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                exitBtnClkSnd.start();
                finishDlg = new Dialog(RollScreen.this);
                finishDlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
                finishDlg.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                finishDlg.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialogInterface) {
                        intent = new Intent();
                        intent.putExtra("returnValue", "returned");
                        setResult(RESULT_OK, intent);
                        outSnd.reset();
                        winSnd.reset();
                        ballClickSound.stop();
                        batClickSound.stop();
                        exitBtnClkSnd.stop();
                        finish();


                    }
                });
                finishDlg.setContentView(R.layout.activity_finish_popup);
                finalScoreTxt = finishDlg.findViewById(R.id.final_score);
                finishCloseBtn = finishDlg.findViewById(R.id.finish_close);
                finalWicketsTxt = finishDlg.findViewById(R.id.final_wickets);
                finalScoreTxt.setText(scoreTxt.getText());
                finalWicketsTxt.setText(wicketTxt.getText());
                finishCloseBtn.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        finishDlg.dismiss();
                    }
                });
                finishDlg.show();
            }
        });
    }

    @Override
    protected void onPause(){
        outSnd.pause();
        winSnd.pause();
        super.onPause();
    }

    @Override
    protected void onStop(){
        outSnd.reset();
        winSnd.reset();
        super.onStop();
    }

    @Override
    protected void onResume(){
        outSnd = MediaPlayer.create(this, R.raw.out_snd);
        winSnd = MediaPlayer.create(this, R.raw.sixer_snd);
        super.onResume();
    }

}