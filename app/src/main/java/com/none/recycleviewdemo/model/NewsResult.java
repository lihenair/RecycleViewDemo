package com.none.recycleviewdemo.model;

import java.util.List;

/**
 * Created by lihenair on 16/6/8.
 */
public class NewsResult {
    public int code;
    public String msg;
    public List<NewsModel> newslist;

    @Override
    public String toString() {
        return "NewsResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", newslist=" + newslist.toString() +
                '}';
    }
}
