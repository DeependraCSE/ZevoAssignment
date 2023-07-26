package com.example.newsassignmentzevo.newslist.fragment;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.example.newsassignmentzevo.R;
import com.example.newsassignmentzevo.databinding.FragmentNewsDetailBinding;
import com.example.newsassignmentzevo.networking.Constant;

public class NewsDetail extends Fragment {
    Context context;
    View view;
    FragmentNewsDetailBinding binding;
    String url = "";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
        if (getArguments() != null) {
            url = getArguments().getString(Constant.NewsUrl,"");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_news_detail, container, false);
        view = binding.getRoot();
        binding.wvNewsDetail.getSettings().setJavaScriptEnabled(true);
        binding.wvNewsDetail.setWebViewClient(new WebViewClient(){
            @SuppressWarnings("deprecation")
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(context, description, Toast.LENGTH_SHORT).show();
            }
            @TargetApi(android.os.Build.VERSION_CODES.M)
            @Override
            public void onReceivedError(WebView view, WebResourceRequest req, WebResourceError rerr) {
                // Redirect to deprecated method, so you can use it in all SDK versions
                onReceivedError(view, rerr.getErrorCode(), rerr.getDescription().toString(), req.getUrl().toString());
            }
        });
        if(url.length() > 0){
            binding.wvNewsDetail.loadUrl(url);
        }else {
            Toast.makeText(context, "Empty Url", Toast.LENGTH_SHORT).show();
        }
        return view;
    }
}