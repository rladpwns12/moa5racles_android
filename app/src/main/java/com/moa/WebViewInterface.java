package com.moa;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;

public class WebViewInterface {

    private WebView mWebView;
    private Activity mContext;
    private final Handler handler = new Handler();


    public WebViewInterface(Activity activity, WebView view) {
        mWebView = view;
        mContext = activity;

    }

    @JavascriptInterface
    public void callSettingsActivity(final String email) {
        Toast.makeText(mContext, "모아에 오신걸 환영합니다.", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(mContext, MenuActivity.class);
        mContext.startActivity(intent);

    }
}