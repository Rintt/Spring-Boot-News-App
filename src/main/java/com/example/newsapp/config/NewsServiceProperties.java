package com.example.newsapp.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConfigurationProperties(prefix = "newsapi")
@ConstructorBinding
public record NewsServiceProperties(String baseUrl, String key) {
}
