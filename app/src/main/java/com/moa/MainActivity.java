package com.moa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.moa.handler.BackPressCloseHandler;

public class MainActivity extends AppCompatActivity {
    private static final String MAIN_URL= "http://192.168.30.166:8089/admin";

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent intent = new Intent(this, LoadingActivity.class);
        startActivity(intent);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);
        button = findViewById(R.id.button);

    }
    public void onClick(View v){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
 
}