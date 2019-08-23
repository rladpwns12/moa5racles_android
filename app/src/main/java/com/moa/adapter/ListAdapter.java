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

public class ListAdapter extends BaseAdapter {
    List<RequestListVO> list;
    Context context;
    LayoutInflater layoutInflater;

    public ListAdapter(List<RequestListVO> list, Context context){
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
            itemLayout = layoutInflater.inflate(R.layout.list_item, viewGroup, false);
        }

        TextView nickTxtV = (TextView)itemLayout.findViewById(R.id.nickTxtV);
        TextView dateTxtV = (TextView)itemLayout.findViewById(R.id.dateTxtV);
        TextView priceTxtV = (TextView)itemLayout.findViewById(R.id.priceTxtV);
        System.out.println("ddddddddddddddddd"+list);
        System.out.println(i+" : "+list.get(i).getPrice());
        nickTxtV.setText(list.get(i).getNick());
        dateTxtV.setText(list.get(i).getDate());
        priceTxtV.setText(list.get(i).getPrice()+"원");

        return itemLayout;
    }
}
