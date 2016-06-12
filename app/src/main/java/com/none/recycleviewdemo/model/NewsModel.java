package com.none.recycleviewdemo.model;

/**
 * Created by lihenair on 16/6/6.
 * id 新闻ID,title字段 新闻标题，link 新闻地址，descr 新闻简述，refinfo 新闻来源, thumb 新闻缩略图,
 time 新闻发布时间。
 */
public class NewsModel {
    public String title;
    public String description;
    public String picUrl;
    public String url;
    public String ctime;

    @Override
    public String toString() {
        return "NewsModel{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", url='" + url + '\'' +
                ", ctime='" + ctime + '\'' +
                '}';
    }
}