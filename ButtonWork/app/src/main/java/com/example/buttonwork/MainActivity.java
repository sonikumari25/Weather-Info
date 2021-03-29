package com.example.buttonwork;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
public void fade(View view ){
    ImageView pooh = (ImageView)findViewById(R.id.pooh);
    ImageView doramon = (ImageView)findViewById(R.id.doramon);
    pooh.animate().alpha(0f).setDuration(2000);
    doramon.animate().alpha(1f).setDuration(2000);

}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}