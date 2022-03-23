package com.example.newsapp.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestClientConfiguration {
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
// Proxy proxy = new Proxy(Proxy.Type.HTTP,
// new InetSocketAddress(PROXY_SERVER_HOST, PROXY_SERVER_PORT));
// SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
// requestFactory.setProxy(proxy);
        return builder
// .requestFactory(() -> requestFactory)
                .build();
    }
}
