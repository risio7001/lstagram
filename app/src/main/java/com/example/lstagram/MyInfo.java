package com.example.lstagram;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MyInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_info);


    }

    public void startActivity(Class c){
        Intent intent = new Intent(this, c);
        startActivity(intent);
        finish();
    }
}