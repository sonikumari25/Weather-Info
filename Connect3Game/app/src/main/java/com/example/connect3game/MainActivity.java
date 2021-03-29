package com.example.connect3game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
public void dropin(View view){
    ImageView counter =(ImageView)view;
    counter.setTranslationY(-1000f);
    counter.setImageResource(R.drawable.black);
    counter.animate().translationYBy(1000f).setDuration(300);
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}