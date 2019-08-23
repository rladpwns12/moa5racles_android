package com.moa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void goToApplyList(View view){
        Intent intent = new Intent(this, ApplyListActivity.class);
        startActivity(intent);
    }
    public void goToRequestList(View view){
        Intent intent = new Intent(this, RequestListActivity.class);
        startActivity(intent);
    }

}