package com.example.newsassignmentzevo.newslist.model_classes;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Model_NewsList {
    @SerializedName("status")
    private String status;
    @SerializedName("totalResults")
    private String totalResults;

    @SerializedName("articles")
    private ArrayList<DataArticles> articles;

    public Model_NewsList(String status, String totalResults, ArrayList<DataArticles> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public ArrayList<DataArticles> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<DataArticles> articles) {
        this.articles = articles;
    }

    public class DataArticles{
        @SerializedName("source")
        private DataSource source;
        @SerializedName("author")
        private String author;
        @SerializedName("title")
        private String title;
        @SerializedName("description")
        private String description;
        @SerializedName("url")
        private String url;
        @SerializedName("urlToImage")
        private String urlToImage;
        @SerializedName("publishedAt")
        private String publishedAt;
        @SerializedName("content")
        private String content;

        public DataArticles(DataSource source, String author,
                            String title, String description,
                            String url, String urlToImage,
                            String publishedAt, String content) {
            this.source = source;
            this.author = author;
            this.title = title;
            this.description = description;
            this.url = url;
            this.urlToImage = urlToImage;
            this.publishedAt = publishedAt;
            this.content = content;
        }

        public DataSource getSource() {
            return source;
        }

        public void setSource(DataSource source) {
            this.source = source;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUrlToImage() {
            return urlToImage;
        }

        public void setUrlToImage(String urlToImage) {
            this.urlToImage = urlToImage;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

    public class DataSource{
        @SerializedName("id")
        private String id;
        @SerializedName("name")
        private String name;

        public DataSource(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}