package com.moa;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.moa.handler.BackPressCloseHandler;

public class LoginActivity extends Activity {
    private static final String MAIN_URL= "http://5racle.powerlinux.co.kr/admin";
    private WebView webView;
    private BackPressCloseHandler backPressCloseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        WebViewInterface mWebViewInterface = new WebViewInterface(LoginActivity.this, webView);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //--start of loading
        backPressCloseHandler = new BackPressCloseHandler(this);
        //--end of loading

        webView = findViewById(R.id.webView);
        webView.setWebViewClient(new MyWebClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setHorizontalScrollBarEnabled(false);//가로스크롤없애기
        webView.setVerticalScrollBarEnabled(false);//세로스크롤없애기
        webView.addJavascriptInterface(mWebViewInterface, "android");
        webView.loadUrl(MAIN_URL);
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