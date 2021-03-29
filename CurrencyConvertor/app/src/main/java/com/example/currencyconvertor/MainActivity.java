package com.example.currencyconvertor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public void convertFunction(View view){
        EditText currencyTextView = (EditText)findViewById(R.id.currencyTextView);
        Double dollaramount = Double.parseDouble(currencyTextView.getText().toString());
        Double rupeeamount = dollaramount * 73.98;
        Toast.makeText(MainActivity.this ,"₹ " +rupeeamount.toString() , Toast.LENGTH_SHORT ).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}