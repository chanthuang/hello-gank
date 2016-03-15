package com.chanthuang.hellogank.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

public class ServiceManager {

    public static final String HOST = "http://gank.io/api/";

    final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").serializeNulls().create();

    private ServiceManager() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HOST)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        mGankService = retrofit.create(GankService.class);
    }

    private static ServiceManager mServiceManagerInstance;

    public static ServiceManager getInstance() {
        if (mServiceManagerInstance == null) {
            mServiceManagerInstance = new ServiceManager();
        }
        return mServiceManagerInstance;
    }

    private GankService mGankService;

    public GankService getGankService() {
        return mGankService;
    }

}
