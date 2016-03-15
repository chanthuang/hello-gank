package com.chanthuang.hellogank.activity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.chanthuang.hellogank.model.Gank;

import java.util.ArrayList;
import java.util.List;

public class GankListAdapter extends BaseAdapter {

    private List<Gank> mGankList;

    public GankListAdapter() {
        mGankList = new ArrayList<>();
    }

    public void setData(List<Gank> ganks) {
        mGankList.clear();
        mGankList.addAll(ganks);
    }

    @Override
    public int getCount() {
        return mGankList.size();
    }

    @Override
    public Gank getItem(int position) {
        return mGankList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView;
        if (convertView == null) {
            textView = new TextView(parent.getContext());
            convertView = textView;
        } else {
            textView = (TextView) convertView;
        }
        Gank gank = getItem(position);
        textView.setText(gank.toString());
        return convertView;
    }
}
