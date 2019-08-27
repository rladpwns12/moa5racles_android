package com.moa;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.List;

public class ApplyInfoActivity extends Activity implements ViewFlipperAction.ViewFlipperCallback
{
    private ViewFlipper flipper;
    private List<ImageView> indexes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_info);

        //UI
        flipper = (ViewFlipper)findViewById(R.id.flipper);
        ImageView index0 = (ImageView)findViewById(R.id.imgIndex0);
        ImageView index1 = (ImageView)findViewById(R.id.imgIndex1);

        //index list
        indexes = new ArrayList<>();
        indexes.add(index0);
        indexes.add(index1);

        //xml을 inflate하여 flipper view에 추가하기
        //inflate
        LayoutInflater inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
        View view1 = inflater.inflate(R.layout.viewflipper1, flipper, false);
        View view2 = inflater.inflate(R.layout.viewflipper2, flipper, false);

        flipper.addView(view1);
        flipper.addView(view2);

        //리스너 설정 - 좌우 터치시 화면넘어가기
        flipper.setOnTouchListener(new ViewFlipperAction(this,flipper));

    }
    public void before(View view){
        finish();
    }
    //인덱스 업데이트
    @Override
    public void onFlipperActionCallback(int position) {
        Log.d("ddd", ""+position);
        for(int i=0; i<indexes.size(); i++){
            ImageView index = indexes.get(i);
            //현재화면의 인덱스 위치면 녹색
            if(i == position){
                index.setImageResource(R.drawable.purple);
            }
            //그외
            else{
                index.setImageResource(R.drawable.white);
            }
        }
    }





}