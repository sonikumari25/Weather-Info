package com.example.signin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
     private TextView Info;
     private EditText Email;
     private EditText Password;
     private Button Login;
     private int counter=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Email=(EditText)findViewById(R.id.Email);
        Password=(EditText)findViewById(R.id.password);
        Info = (TextView)findViewById(R.id.attemptInfo);
        Login = (Button)findViewById(R.id.signIn);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Email.getText().toString(), Password.getText().toString());
            }
        });

    }
    private void validate(String userEmail , String userPassword){
        if(userEmail.equals("soni123@gmail.com") && userPassword.equals("123456") ){
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        }else{
            counter--;
            Info.setText(String.valueOf(counter)+" attempts left");
            if(counter==0){
                Login.setEnabled(false);
            }
        }
    }
}