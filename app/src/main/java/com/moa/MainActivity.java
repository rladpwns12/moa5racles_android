package com.moa;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.moa.handler.BackPressCloseHandler;

public class MainActivity extends AppCompatActivity {
    private static final String MAIN_URL= "http://5racle.powerlinux.co.kr/admin";
    private WebView webView;
    private WebSettings webSettings;
    private BackPressCloseHandler backPressCloseHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent intent = new Intent(this, LoadingActivity.class);
        startActivity(intent);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //-- start of loading
        backPressCloseHandler = new BackPressCloseHandler(this);
        //-- end of loading

        //-- start of webView
        webView = (WebView)findViewById(R.id.webView);
        webView.setWebViewClient(new MyWebClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setHorizontalScrollBarEnabled(false);//가로스크롤없애기
        webView.setVerticalScrollBarEnabled(false);//세로스크롤없애기
        webView.loadUrl(MAIN_URL);
        //-- end of webView
    }

    class MyWebClient extends WebViewClient {
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
    }
}