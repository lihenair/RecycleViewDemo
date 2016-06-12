package com.none.recycleviewdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.none.recycleviewdemo.R;
import com.none.recycleviewdemo.model.NewsModel;

import java.util.List;

/**
 * Created by lihenair on 16/6/6.
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private Context context;
    private List<NewsModel> list;

    public NewsAdapter(Context context, List<NewsModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(NewsAdapter.ViewHolder holder, int position) {
        NewsModel model = list.get(position);
        holder.mNewsContent.setText(model.title);
//        holder.mNewsTime.setText(model.ctime);
        Glide.with(context).load(model.picUrl).fitCenter().crossFade().into(holder.mNewsPic);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mNewsContent;
        public ImageView mNewsPic;
//        public TextView mNewsTime;

        public ViewHolder(View v) {
            super(v);
            mNewsContent = (TextView) v.findViewById(R.id.title);
            mNewsPic = (ImageView) v.findViewById(R.id.pic);
//            mNewsTime = (TextView) v.findViewById(R.id.time);
        }
    }
}
