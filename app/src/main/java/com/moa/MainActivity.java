package com.moa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.moa.handler.BackPressCloseHandler;

public class MainActivity extends AppCompatActivity {
    private static final String MAIN_URL= "http://5racle.powerlinux.co.kr/admin";
    private WebView webView;
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
   /* class MyWebClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);

            return true;
        }
    }

    @Override// -- 뒤로가기 클릭시 엑티비티 종료 및 전환이 아닌 이전 페이지로 이동하게 한다.
    public void onBackPressed() {
        if(webView.getOriginalUrl().equalsIgnoreCase(MAIN_URL)){
            backPressCloseHandler.onBackPressed();
        }else if(webView.canGoBack()){
            webView.goBack();
        }else{
            super.onBackPressed();
        }
    }*/
}