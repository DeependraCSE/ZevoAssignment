package com.example.newsassignmentzevo.newslist.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.newsassignmentzevo.R;
import com.example.newsassignmentzevo.databinding.ItemNewsListBinding;
import com.example.newsassignmentzevo.newslist.listner.NewsClickListner;
import com.example.newsassignmentzevo.newslist.model_classes.Model_NewsList;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class NewsLisAdapter extends RecyclerView.Adapter<NewsLisAdapter.ViewHolder> {
    Context context;
    ArrayList<Model_NewsList.DataArticles> data;
    ItemNewsListBinding binding;
    NewsClickListner newsClickListner;

    public NewsLisAdapter(Context context, ArrayList<Model_NewsList.DataArticles> data, NewsClickListner newsClickListner) {
        this.context = context;
        this.data = data;
        this.newsClickListner = newsClickListner;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_news_list, parent, false);
        binding = DataBindingUtil.bind(view);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Model_NewsList.DataArticles item = data.get(position);
        binding.setNewsData(item);
        binding.flNewsDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newsClickListner.onNewsItemClick(item);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_news_image);
            textView = itemView.findViewById(R.id.tv_title);
        }
    }
}
