package com.chanthuang.hellogank.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Gank /*implements Cloneable, Serializable */{

//    public long id;
//    public String objectId;
    public String _id;
    public String _ns;
    public Date createdAt;
    public String desc;
    public Date publishedAt;
    public String type;
    public String url;
    public String used;
    public String who;

    @Override
    public String toString() {
        return new StringBuilder()
                .append("_id: ").append(_id).append("\n")
                .append("_ns: ").append(_ns).append("\n")
                .append("type: ").append(type).append("\n")
                .append("desc: ").append(desc).append("\n")
                .append("url: ").append(url).append("\n")
                .append("who: ").append(who).append("\n")
                .append("createdAt: ").append(new SimpleDateFormat("yyyy/MM/dd").format(createdAt)).append("\n")
                .append("publishedAt: ").append(new SimpleDateFormat("yyyy/MM/dd").format(publishedAt))
                .toString();
    }
}
