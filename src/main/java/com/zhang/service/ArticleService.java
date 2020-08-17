package com.zhang.service;

import com.zhang.entity.Article;

import java.util.List;

public interface ArticleService {

    public void saveArticle(Article article);

    public void updateArticle(Article article);

    public void delArticle(Long id);

    public Article queryById(Long id);

    public List<Article> queryAll();
}
