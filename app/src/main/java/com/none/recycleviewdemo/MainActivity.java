package com.none.recycleviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.none.recycleviewdemo.adapter.NewsAdapter;
import com.none.recycleviewdemo.model.NewsModel;
import com.none.recycleviewdemo.model.NewsResult;
import com.none.recycleviewdemo.service.NewsClient;
import com.none.recycleviewdemo.service.NewsService;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ArrayList<NewsModel> mNews;

    @BindView(R.id.rv)
    RecyclerView mRecyclerView;
    @BindView(R.id.empty)
    TextView mEmpty;
    private NewsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        RecyclerView.LayoutManager manager = new GridLayoutManager(this, 3);
        mRecyclerView.setLayoutManager(manager);
        mNews = new ArrayList<>();
        mAdapter = new NewsAdapter(this, mNews);
        mRecyclerView.setAdapter(mAdapter);

        NewsService service = new NewsClient().getService();
        Call<NewsResult> call = service.getNews(Constant.TYPE_GOSSIP, Constant.API_KEY, 10, 0, "柳岩", 1);
        call.enqueue(new Callback<NewsResult>() {
            @Override
            public void onResponse(Call<NewsResult> call, Response<NewsResult> response) {
                Log.d("TAG", response.isSuccessful() + "");
                if (response.isSuccessful()) {
                    NewsResult result = response.body();
                    Log.d("TAG", "code = " + result.code);
                    if (result.code == 200) {
                        if (result.newslist != null && !result.newslist.isEmpty()) {
                            Log.d("TAG", result.toString());
                            mNews.addAll(result.newslist);
                            mAdapter.notifyDataSetChanged();
                            mEmpty.setVisibility(View.GONE);
                        }
                    } else {
                        mRecyclerView.setVisibility(View.GONE);
                        mEmpty.setVisibility(View.VISIBLE);
                    }
                }
            }

            @Override
            public void onFailure(Call<NewsResult> call, Throwable t) {
                Log.d("TAG", "onFailure");
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
