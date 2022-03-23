package com.example.newsapp.service;

import com.example.newsapp.domain.NewsItem;

import java.util.List;

public interface NewsService {
    List<NewsItem> findNews(int count);
}

