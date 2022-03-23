package com.example.newsapp.controller;

import com.example.newsapp.domain.NewsItem;
import com.example.newsapp.domain.NewsUser;
import com.example.newsapp.service.NewsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(NewsController.class)
class NewsControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private NewsService newsService;

    @Test
    void testNewsController() throws Exception {
        var mockItems = new ArrayList<NewsItem>();
        for (int i = 0; i < 5; i++) {
            mockItems.add(new NewsItem("Title " + i, "Desc", "", ""));
        }
        when(newsService.findNews(5)).thenReturn(mockItems);
        mockMvc.perform(get("/news"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("news",
                        equalTo(mockItems)))
                .andExpect(content().string(
                        containsString("Title 0")));
    }
    @Test
    void testNewsControllerWithParameter() throws Exception {
        var mockItems = new ArrayList<NewsItem>();
        for (int i = 0; i < 12; i++) {
            mockItems.add(new NewsItem("Title " + i, "Desc", "", ""));
        }
        when(newsService.findNews(12)).thenReturn(mockItems);
        mockMvc.perform(get("/news?count=12"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("news",
                        equalTo(mockItems)))
                .andExpect(content().string(
                        containsString("Title 0")));
    }


    }
