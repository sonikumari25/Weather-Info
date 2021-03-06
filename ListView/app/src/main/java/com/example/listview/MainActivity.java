package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView myList = (ListView) findViewById(R.id.myList);
        ArrayList<String> myFriends = new ArrayList<String>();
        myFriends.add("Ram");
        myFriends.add("Rina");
        myFriends.add("Soni");
        myFriends.add("Shivam");
        myFriends.add("Simi");
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myFriends);
        myList.setAdapter(myAdapter);
        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
             Toast toast=Toast.makeText(getApplicationContext(), "hello" + myFriends.get(position), Toast.LENGTH_SHORT);
             toast.show();
            }
        });
    }
}
