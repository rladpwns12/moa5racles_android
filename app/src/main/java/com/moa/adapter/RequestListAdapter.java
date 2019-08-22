package com.moa.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.moa.R;
import com.moa.model.vo.RequestListVO;

import java.util.List;

public class RequestListAdapter extends BaseAdapter {
    List<RequestListVO> list;
    Context context;
    LayoutInflater layoutInflater;

    public RequestListAdapter(List<RequestListVO> list, Context context){
        this.list = list;
        this.context = context;
        this.layoutInflater = layoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemLayout = view;
        if(view == null){
            itemLayout = layoutInflater.inflate(R.layout.activity_requestlist, viewGroup, false);
        }

        TextView nickTxtV = itemLayout.findViewById(R.id.nickTxtV);
        TextView dateTxtV = itemLayout.findViewById(R.id.dateTxtV);
        TextView priceTxtV = itemLayout.findViewById(R.id.priceTxtV);

        RequestListVO requestListVO = list.get(i);
        nickTxtV.setText(requestListVO.getNick());
        dateTxtV.setText(requestListVO.getDate()+" "+requestListVO.getTime());
        priceTxtV.setText(requestListVO.getPrice());

        return itemLayout;
    }
}
