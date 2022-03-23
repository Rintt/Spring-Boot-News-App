package com.example.newsapp.service;

import com.example.newsapp.domain.NewsUser;
import com.example.newsapp.repository.NewsUserRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class NewsUserRepositoryImpl implements NewsUserRepository {
    private Map<String, NewsUser> map = new ConcurrentHashMap<>();

    public NewsUserRepositoryImpl() {
        map.put("buck", new NewsUser("buck", "buck", "Buck", "Rogers", LocalDate.now()));
        map.put("ufuk", new NewsUser("ufuk","ufuk", "Ufuk", "Algac", LocalDate.now()));
    }
    @Override
    public NewsUser findByUsername(String username) {
        return map.get(username);
    }
    @Override
    public NewsUser save(NewsUser user) {
        map.put(user.getUsername(), user);
        return user;
    }
    @Override
    public long count() {
        return map.size();
    }
}