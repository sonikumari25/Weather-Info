package com.example.hikerswatch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    LocationManager locationManager;
    LocationListener locationListener;
    TextView textView;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                if (ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView)findViewById(R.id.textView);
        locationManager=(LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        locationListener=new LocationListener() {
            @Override
            public void onLocationChanged(@NonNull Location location) {
                Geocoder geocoder=new Geocoder(getApplicationContext(), Locale.getDefault());

                try {
                    List<Address> listAddresses=geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);
                    if(listAddresses!=null && listAddresses.size()>0){
                        String address="";
                        String display="";
                        double accuracy;
                        Log.i("Place Info",listAddresses.get(0).toString());
                        if(listAddresses.get(0).hasLatitude()==true){
                           display+="Latitude "+listAddresses.get(0).getLatitude()+"\r\n";
                        }
                        if(listAddresses.get(0).hasLongitude()==true){
                            display+="Longitude "+listAddresses.get(0).getLongitude()+"\r\n";
                        }
                        accuracy=location.getAccuracy();
                        display+="Accuracy "+String.valueOf(accuracy)+"\r\n";
                        if(listAddresses.get(0).getSubThoroughfare()!=null){
                            address+="Address"+" : "+"\r\n"+listAddresses.get(0).getSubThoroughfare()+"\r\n";
                        }
                        if(listAddresses.get(0).getThoroughfare()!=null){
                            address+=listAddresses.get(0).getThoroughfare()+"\r\n";
                        }
                        if(listAddresses.get(0).getLocality()!=null){
                            address+=listAddresses.get(0).getLocality()+"\r\n";
                        }
                        if(listAddresses.get(0).getPostalCode()!=null){
                            address+=listAddresses.get(0).getPostalCode()+"\r\n";
                        }
                        if(listAddresses.get(0).getCountryName()!=null){
                            address+=listAddresses.get(0).getCountryName()+"\r\n";
                        }
                        display+=address;
                        textView.setText(display);

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);
        }else{
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,locationListener);
            Location lastKnownLocation  = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        }


    }
}