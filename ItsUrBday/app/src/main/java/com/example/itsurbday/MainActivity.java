package com.example.itsurbday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mplayer;
    AudioManager audioManager;
    TextView textView;
    CountDownTimer count;
    Button button;
    int track=40;
    public void clickMe(View view){
        Intent intent=new Intent(getApplicationContext(),SecondActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        textView=(TextView)findViewById(R.id.textView);
        button=(Button)findViewById(R.id.button);
        mplayer = MediaPlayer.create(this, R.raw.happybirthday);
        audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        mplayer.start();
        count=new CountDownTimer(40000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                track--;
                if(track==30){
                    imageView.setImageResource(R.drawable.swap2);
                    String s1="Thankyou for ur Unconditional love...silly talks... and for Everything...Sending U lots of hugs and kisses.... ";
                    textView.setText(s1);

                }
                if(track==20){
                    imageView.setImageResource(R.drawable.swap3);
                    String s2="OMG...Look at this innocent face...bas dikhta innocent h...Love u Tons...";
                    textView.setText(s2);
                }
                if(track==10){
                    imageView.setImageResource(R.drawable.swap4);
                    String s3="No matter what Sweetu Will always be there for u....And will always Love U...";
                    textView.setText(s3);

                }

                Log.i("Time left",String.valueOf(millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {
             button.setVisibility(View.VISIBLE);

            }
        }.start();


    }
}