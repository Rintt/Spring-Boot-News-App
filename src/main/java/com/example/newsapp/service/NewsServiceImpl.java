package com.example.newsapp.service;

import com.example.newsapp.config.NewsServiceProperties;
import com.example.newsapp.domain.NewsItem;
import com.example.newsapp.domain.NewsItemContainer;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class NewsServiceImpl implements NewsService {
    private NewsServiceProperties properties;
    private RestTemplate restTemplate;

    public NewsServiceImpl(NewsServiceProperties properties,
                           RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.properties = properties;
    }

    private static final String api = "v2/top-headlines?" +
            "country=de&" +
            "apiKey={apikey}&" +
            "pageSize={count}&" +
            "page=0";

    @Override
    public List<NewsItem> findNews(int count) {
        var params = Map.of(
                "count", String.valueOf(count),
                "apikey", properties.key()
        );
        var container =
                restTemplate.getForObject(
                        properties.baseUrl() + api,
                        NewsItemContainer.class,
                        params);
        return container.articles();
    }
}
