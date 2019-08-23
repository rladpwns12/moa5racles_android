package com.moa.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.moa.R;
import com.moa.model.vo.ApplyListInfoVO;

import java.util.List;

public class ApplyListAdapter extends BaseAdapter {
    List<ApplyListInfoVO> list;
    Context context;
    LayoutInflater layoutInflater;

    public ApplyListAdapter(List<ApplyListInfoVO> list, Context context){
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
            itemLayout = layoutInflater.inflate(R.layout.applylist_item, viewGroup, false);
        }

        TextView nickTxtV = (TextView)itemLayout.findViewById(R.id.nickTxtV);
        TextView dateTxtV = (TextView)itemLayout.findViewById(R.id.dateTxtV);
        TextView priceTxtV = (TextView)itemLayout.findViewById(R.id.priceTxtV);
        TextView addressTxtV = (TextView)itemLayout.findViewById(R.id.addressTxtV);
        TextView typeTxtV = (TextView)itemLayout.findViewById(R.id.typeTxtV);

        System.out.println(i+" : "+list.get(i).getPrice());

        nickTxtV.setText(list.get(i).getNick());
        dateTxtV.setText("신청날짜 "+list.get(i).getDate());
        priceTxtV.setText("요청가격 "+list.get(i).getPrice()+"원");
        addressTxtV.setText("주소 "+list.get(i).getBaseAddress()+" "+list.get(i).getDetailAddress());
        typeTxtV.setText(list.get(i).getTransactionType());
        return itemLayout;
    }
}
