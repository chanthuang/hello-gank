package com.chanthuang.hellogank.Service;

import com.chanthuang.hellogank.model.GankData;
import com.chanthuang.hellogank.model.GankHistory;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

public interface GankService {

    @GET("day/history")
    Observable<GankHistory> getGankHistory();

    @GET("day/{year}/{month}/{day}")
    Observable<GankData> getGankData(
            @Path("year") int year,
            @Path("month") int month,
            @Path("day") int day
    );
}
