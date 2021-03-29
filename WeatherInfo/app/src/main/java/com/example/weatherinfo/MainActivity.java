package com.example.weatherinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {
    EditText cityName;
    TextView weatherDisplay;
    public void findWeather(View view){
        try {
            String city = URLEncoder.encode(cityName.getText().toString(),"UTF-8");
            Log.i("city Name",city);
            InputMethodManager mgr=(InputMethodManager)getSystemService(getApplicationContext().INPUT_METHOD_SERVICE);
            mgr.hideSoftInputFromWindow(cityName.getWindowToken(),0);
            DownloadTask task=new DownloadTask();
            task.execute("https://api.openweathermap.org/data/2.5/weather?q="+city+"&appid=6bcaafc4522d1be80b0023c7420995ac" );
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cityName=(EditText)findViewById(R.id.cityName);
        weatherDisplay=(TextView)findViewById(R.id.weatherDisplay);

    }
    public class DownloadTask extends AsyncTask<String, Void , String> {
        @Override
        protected String doInBackground(String... urls) {
            String result ="";
            try {
               URL url = new URL(urls[0]);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in=urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                int data = reader.read();
                while (data!=-1){
                    char current =(char)data;
                    result +=current;
                    data = reader.read();
                }
                return  result;
            } catch (MalformedURLException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }
            return result;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            try{
                String message="";
                JSONObject jsonObject=new JSONObject(result);
                String weatherInfo=jsonObject.getString("weather");
                Log.i("weather Content",weatherInfo);
                JSONArray arr=new JSONArray(weatherInfo);
                for(int i=0;i<arr.length();i++){
                    JSONObject jsonPart=arr.getJSONObject(i);
                    String main="";
                    String description="";
                    main=jsonPart.getString("main");
                    description=jsonPart.getString("description");
                    if(main!="" && description!=""){
                        message+=main+": "+description+"\r\n";
                    }
                }
                if(message!=""){
                 weatherDisplay.setText(message);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

    }

}