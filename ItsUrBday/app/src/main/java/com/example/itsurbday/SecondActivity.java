package com.example.itsurbday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class SecondActivity<unicode> extends AppCompatActivity {
    EditText etNumber;
    ImageButton btCall;
    TextView textView4;
    String ans;
    int unicode = 0x1F60D;
    public String getEmojiByUnicode(int unicode){
        return new String(Character.toChars(unicode));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        etNumber=(EditText)findViewById(R.id.et_number);
        btCall=(ImageButton)findViewById(R.id.bt_call);
        textView4=(TextView)findViewById(R.id.textView4);
        btCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone=etNumber.getText().toString();
                if(phone.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please Enter phone numver",Toast.LENGTH_SHORT).show();
                }
                else {
                    String s="tel:"+phone;
                    Intent intent=new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse(s));
                    startActivity(intent);
                }
            }
        });
      ans= getEmojiByUnicode( 0x1F60D);
        textView4.setText("Call...Ur Sona is Waiting "+ans);
    }
}