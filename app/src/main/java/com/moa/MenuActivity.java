package com.moa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MenuActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = new Intent(this, LoadingActivity.class);
        startActivity(intent);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

    }

    public void goToApplyList(View view){
        Intent intent = new Intent(this, UserListActivity.class);
        startActivity(intent);
    }
    public void goToRequestList(View view){
        Intent intent = new Intent(this, RequestListActivity.class);
        startActivity(intent);
    }

}