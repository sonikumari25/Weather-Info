package com.example.higherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int randomnumber;
public void clickFunction(View view){
    EditText editTextNumber = (EditText)findViewById(R.id.editTextNumber);
     int guessnumber =Integer.parseInt(editTextNumber.getText().toString());
     if(randomnumber > guessnumber)
         Toast.makeText(MainActivity.this , "higher!" ,Toast.LENGTH_SHORT).show();
     else if(randomnumber <guessnumber) {
         Toast.makeText(MainActivity.this, "lower!", Toast.LENGTH_SHORT).show();
     }
         else if(randomnumber==guessnumber){
         Toast.makeText(MainActivity.this, "congrats!  Try Again!", Toast.LENGTH_SHORT).show();
         Random rand = new Random();
         randomnumber = rand.nextInt(20)+1;
         }
     }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Random rand = new Random();
         randomnumber = rand.nextInt(20) + 1;
    }
}