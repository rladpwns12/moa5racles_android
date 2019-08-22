package com.moa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.moa.handler.RequestListActivity;

public class MenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

    }

    public void goToApplyList(View view){
        Toast.makeText(this, "현재 서비스 공사중입니다.", Toast.LENGTH_LONG).show();
    }
    public void goToRequestList(View view){
        Intent intent = new Intent(this, RequestListActivity.class);
        startActivity(intent);
    }

}