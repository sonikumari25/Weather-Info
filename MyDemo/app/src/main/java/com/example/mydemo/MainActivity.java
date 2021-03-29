package com.example.mydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void onRegisterBtnClick (View view) {
        TextView edtFirst = findViewById(R.id.edtFirst);
        TextView edtLast = findViewById(R.id.edtLast);
        TextView edtEmail = findViewById(R.id.edtEmail);
        EditText txtView = findViewById(R.id.TxtView);
        EditText txtView2 = findViewById(R.id.txtView2);
        EditText txtView3 = findViewById(R.id.txtView3);
        edtFirst.setText("First Name" +txtView.getText().toString());
        edtLast.setText("Last Name" + txtView2.getText().toString());
        edtEmail.setText("Email "+ txtView3.getText().toString());
    }
}
