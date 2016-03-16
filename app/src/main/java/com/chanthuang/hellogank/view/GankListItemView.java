package com.chanthuang.hellogank.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chanthuang.hellogank.R;
import com.chanthuang.hellogank.model.Gank;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GankListItemView extends LinearLayout {

    @Bind(R.id.gank_item_title)
    protected TextView mTitleTextView;

    @Bind(R.id.gank_item_author)
    protected TextView mAuthorTextView;

    public GankListItemView(Context context) {
        super(context);
    }

    public GankListItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GankListItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);
    }

    public void render(Gank gank) {
        mTitleTextView.setText(gank.desc);
        mAuthorTextView.setText(gank.who);
    }

}
