package in.focusminds.fractioncricket;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {


    Button playBtn, instBtn;
    TextView closeBtn;
    Intent intent;
    MediaPlayer btnClkSnd;
    ImageView iAbout,imtathLoveAbout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playBtn = findViewById(R.id.btn_play);
        instBtn = findViewById(R.id.instructions_btn);
        btnClkSnd = MediaPlayer.create(this, R.raw.all_btn_clk_snd);


        imtathLoveAbout = findViewById(R.id.mathlove);
        imtathLoveAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btnClkSnd.start();
                Intent iAbout = new Intent(MainActivity.this,Mathlove.class);
                startActivity(iAbout);
            }
        });


        iAbout = findViewById(R.id.focusminds);
        iAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btnClkSnd.start();
                Intent iAbout = new Intent(MainActivity.this,FocusMindsAbout.class);
                startActivity(iAbout);
            }
        });


        instBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnClkSnd.start();
                final Dialog closeDlg = new Dialog(MainActivity.this);
                closeDlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
                closeDlg.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                closeDlg.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialogInterface) {


                    }
                });
                closeDlg.setContentView(R.layout.activity_instructions_popup);
                closeBtn = closeDlg.findViewById(R.id.close_btn);
                closeBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        closeDlg.dismiss();
                    }
                });
                closeDlg.show();
            }
        });

    }

    public void playClick(View view) {
        btnClkSnd.start();
        intent = new Intent(getApplicationContext(),GameModeSelection.class);
        startActivity(intent);
    }

}