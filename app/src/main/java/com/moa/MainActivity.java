package com.moa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String MAIN_URL= "http://5racle.powerlinux.co.kr/admin";

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = new Intent(this, LoadingActivity.class);
        startActivity(intent);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);

        LinearLayout mainLayout = (LinearLayout) findViewById (R.id.mainLayout);
        mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}