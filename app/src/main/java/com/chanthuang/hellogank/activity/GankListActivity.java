package com.chanthuang.hellogank.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.chanthuang.hellogank.R;
import com.chanthuang.hellogank.Service.GankService;
import com.chanthuang.hellogank.Service.ServiceManager;
import com.chanthuang.hellogank.model.Gank;
import com.chanthuang.hellogank.model.GankData;
import com.chanthuang.hellogank.model.GankHistory;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class GankListActivity extends AppCompatActivity {

    @Bind(R.id.fab)
    protected FloatingActionButton mFloatingActionButton;

    @Bind(R.id.content_textview)
    protected TextView mContentTextView;

    @Bind(R.id.gank_listview)
    protected ListView mGankListView;

    private GankListAdapter mGankListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gank_list);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mGankListAdapter = new GankListAdapter();
        mGankListView.setAdapter(mGankListAdapter);
    }

    protected void getGankHistory() {
        GankService gankService = ServiceManager.getInstance().getGankService();
        gankService.getGankHistory()
                .subscribe(new Action1<GankHistory>() {
                    @Override
                    public void call(GankHistory gankHistory) {
                        Log.d("chant", "[getGankHistory] [onCall]");
//                        StringBuilder stringBuilder = new StringBuilder();
//                        for (String string : gankHistory.results) {
//                            stringBuilder.append(string).append("\n");
//                        }
//                        mContentTextView.setText(stringBuilder);
                    }
                });
    }

    @OnClick(R.id.fab)
    protected void getGankData() {
        Calendar today = Calendar.getInstance();
        today.setTime(new Date(System.currentTimeMillis()));
        GankService gankService = ServiceManager.getInstance().getGankService();
        gankService.getGankData(today.get(Calendar.YEAR), today.get(Calendar.MONTH) + 1, today.get(Calendar.DAY_OF_MONTH))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map(new Func1<GankData, GankData.GankResult>() {
                    @Override
                    public GankData.GankResult call(GankData gankData) {
                        return gankData.results;
                    }
                })
                .map(new Func1<GankData.GankResult, List<Gank>>() {
                    @Override
                    public List<Gank> call(GankData.GankResult gankResult) {
                        return gankResult.toList();
                    }
                })
                .subscribe(new Subscriber<List<Gank>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        mContentTextView.setText("Error: " + e.getMessage());
                        mContentTextView.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onNext(List<Gank> ganks) {
                        mContentTextView.setVisibility(View.GONE);
                        notifyAdapter(ganks);
                    }
                });
    }

    private void notifyAdapter(List<Gank> ganks) {
        mGankListAdapter.setData(ganks);
        mGankListAdapter.notifyDataSetChanged();
    }

}
