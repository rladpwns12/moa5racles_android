package com.moa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.moa.handler.BackPressCloseHandler;

public class MainActivity extends AppCompatActivity {
    private static final String MAIN_URL= "http://5racle.powerlinux.co.kr/admin";
    private WebView webView;
    private WebSettings webSettings;
    private BackPressCloseHandler backPressCloseHandler;
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
        System.out.println("ok");
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
 
}