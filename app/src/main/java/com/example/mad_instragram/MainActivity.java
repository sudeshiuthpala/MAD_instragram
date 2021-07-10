package com.example.mad_instragram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.mad_instragram.ui.home.HomeFragment;

public class MainActivity extends AppCompatActivity {
    private static int splash_time_out=2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent=new Intent(MainActivity.this, Home.class);
                startActivity(homeIntent);
                finish();
            }
        }, splash_time_out);
    }
}