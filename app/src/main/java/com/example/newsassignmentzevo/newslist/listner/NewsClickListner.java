package com.example.newsassignmentzevo.newslist.listner;

import com.example.newsassignmentzevo.newslist.model_classes.Model_NewsList;

public interface NewsClickListner {
    void onNewsItemClick(Model_NewsList.DataArticles articles);
}
