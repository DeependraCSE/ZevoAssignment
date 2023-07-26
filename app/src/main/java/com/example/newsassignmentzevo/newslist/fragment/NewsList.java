package com.example.newsassignmentzevo.newslist.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.newsassignmentzevo.R;
import com.example.newsassignmentzevo.databinding.FragmentNewsListBinding;
import com.example.newsassignmentzevo.networking.Constant;
import com.example.newsassignmentzevo.networking.RetrofitClient;
import com.example.newsassignmentzevo.newslist.adapter.NewsLisAdapter;
import com.example.newsassignmentzevo.newslist.listner.NewsClickListner;
import com.example.newsassignmentzevo.newslist.model_classes.Model_NewsList;

import java.util.HashMap;
import java.util.Map;

public class NewsList extends Fragment {
    Context context;
    FragmentNewsListBinding binding;
    View view;
    RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_news_list, container, false);
        view = binding.getRoot();
        context = getActivity();
        recyclerView = binding.rvNewsList;
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        getNewsList();
        return view;
    }

    public void getNewsList() {
        Map<String, String> params = new HashMap<>();
        params.put(Constant.KEY_Country, Constant.KEY_CountryValue);
        params.put(Constant.KEY_ApiKey, Constant.KEY_ApiKeyValue);
        Call<Model_NewsList> call = RetrofitClient.getInstance().getMyApi().getNewsList(params);
        call.enqueue(new Callback<Model_NewsList>() {
            @Override
            public void onResponse(Call<Model_NewsList> call, Response<Model_NewsList> response) {
                Model_NewsList res = response.body();
                Log.i("status", res.getStatus());
                Log.i("totalResults", res.getTotalResults());
                recyclerView.setAdapter(new NewsLisAdapter(context,res.getArticles(), newsClickListner));
            }

            @Override
            public void onFailure(Call<Model_NewsList> call, Throwable t) {
                Toast.makeText(getActivity(), "An error has occured", Toast.LENGTH_LONG).show();
            }

        });
    }

    NewsClickListner newsClickListner = articles -> {
        Bundle bundle = new Bundle();
        bundle.putString(Constant.NewsUrl,articles.getUrl());
        Fragment fragment = new NewsDetail();
        fragment.setArguments(bundle);
        getFragmentManager().beginTransaction().replace(R.id.container, fragment).addToBackStack(null).commit();
    };
}