package com.chanthuang.hellogank.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

public class ServiceManager {

    public static final String HOST = "http://gank.io/api/";

    final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").serializeNulls().create();

    private Retrofit mRetrofit;

    private ServiceManager() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(HOST)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    private static ServiceManager mServiceManagerInstance;

    private static ServiceManager getInstance() {
        if (mServiceManagerInstance == null) {
            mServiceManagerInstance = new ServiceManager();
        }
        return mServiceManagerInstance;
    }

    private HashMap<Class, Object> mMap = new HashMap<>();

    public static <T> T of(Class<T> clazz) {
        return getInstance().getService(clazz);
    }

    @SuppressWarnings("unchecked")
    private <T> T getService(Class<T> clazz) {
        if (!mMap.containsKey(clazz)) {
            T service = create(clazz);
            mMap.put(clazz, service);
            return service;
        } else {
            return (T) mMap.get(clazz);
        }
    }

    private <T> T create(Class<T> clazz) {
        return mRetrofit.create(clazz);
    }
}
