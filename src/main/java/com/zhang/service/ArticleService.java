package com.zhang.service;

import com.zhang.entity.Article;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {
    public Long getArticle(Article article) {
        return article.getId();
    }
}
