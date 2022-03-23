package com.example.newsapp.repository;

import com.example.newsapp.domain.NewsUser;

public interface NewsUserRepository {
    NewsUser findByUsername(String username);
    NewsUser save(NewsUser user);
    long count();
}

