package com.chanthuang.hellogank.activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.chanthuang.hellogank.R;
import com.chanthuang.hellogank.model.Gank;
import com.chanthuang.hellogank.view.GankListItemView;

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
        GankListItemView itemView;
        if (convertView == null) {
            itemView = (GankListItemView) LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.gank_list_item, parent, false);
        } else {
            itemView = (GankListItemView) convertView;
        }
        Gank gank = getItem(position);
        itemView.render(gank);
        return itemView;
    }
}
