package com.chanthuang.hellogank.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class GankData {

    public boolean error;
    public List<String> category;
    public GankResult results;

    public static class GankResult {
        @SerializedName("Android") public List<Gank> androidList;
        @SerializedName("iOS") public List<Gank> iOSList;
        @SerializedName("休息视频") public List<Gank> 休息视频List;
        @SerializedName("福利") public List<Gank> 妹纸List;
        @SerializedName("拓展资源") public List<Gank> 拓展资源List;
        @SerializedName("瞎推荐") public List<Gank> 瞎推荐List;
        @SerializedName("App") public List<Gank> appList;

        public List<Gank> toList() {
            List<Gank> list = new ArrayList<>();
            if (androidList != null) {
                list.addAll(androidList);
            }
            if (iOSList != null) {
                list.addAll(iOSList);
            }
            if (休息视频List != null) {
                list.addAll(休息视频List);
            }
            if (妹纸List != null) {
                list.addAll(妹纸List);
            }
            if (拓展资源List != null) {
                list.addAll(拓展资源List);
            }
            if (瞎推荐List != null) {
                list.addAll(瞎推荐List);
            }
            if (appList != null) {
                list.addAll(appList);
            }
            return list;
        }
    }
}
