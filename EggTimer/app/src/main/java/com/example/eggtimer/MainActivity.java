package com.example.eggtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    int track=30;
    CountDownTimer count;
    SeekBar seekBar;
    public void onClick(View view) {
        int left;
        Button controller = (Button) findViewById(R.id.button);
        if (controller.getText().equals("GO")) {
            controller.setText("STOP");
            seekBar.setEnabled(false);
            if (track > 30) {
                left = track - 30;
               count = new CountDownTimer(left * 1000, 1000) {
                   @Override
                   public void onTick(long millisUntilFinished) {
                       track--;
                       textView.setText(track/60+":"+track%60);

                   }

                   @Override
                   public void onFinish() {
                       controller.setText("Go");
                       seekBar.setEnabled(true);
                   }
               }.start();

            }
            else{
                count=new CountDownTimer(track*1000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                       track--;
                        textView.setText("00"+":"+Integer.toString(track));
                    }

                    @Override
                    public void onFinish() {
                        MediaPlayer mplayer=MediaPlayer.create(getApplicationContext(),R.raw.horn);
                        mplayer.start();

                    }
                }.start();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         seekBar = (SeekBar)findViewById(R.id.seekBar);
        seekBar.setMax(600);
        seekBar.setProgress(30);
        ImageView imageView=(ImageView)findViewById(R.id.imageView);
         textView=(TextView)findViewById(R.id.textView);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int remainder;
                int quotient;
                track=progress;
                 if(progress%60==0){
                    quotient=progress/60;
                    textView.setText(Integer.toString(quotient)+":"+"00");
                 }
                 else if(progress<60){
                     textView.setText("00"+":"+Integer.toString(progress));
                 }
                 else{
                    remainder=progress%60;
                    quotient=progress/60;
                    textView.setText(Integer.toString(quotient)+":"+Integer.toString(remainder));
                 }

               }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}