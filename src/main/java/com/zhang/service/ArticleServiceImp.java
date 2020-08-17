package com.zhang.service;

import com.zhang.dao.ArticleJdbcDao;
import com.zhang.entity.Article;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ArticleServiceImp implements ArticleService {

    @Resource
    private ArticleJdbcDao articledao;

    @Override
    public void saveArticle(Article article) {
        articledao.saveArticle(article);
    }

    @Override
    public void updateArticle(Article article) {
        articledao.updateArticle(article);
    }

    @Override
    public void delArticle(Long id) {
        articledao.delArticle(id);
    }

    @Override
    public Article queryById(Long id) {
        return articledao.queryById(id);
    }

    @Override
    public List<Article> queryAll() {
        return articledao.queryAll();
    }
}
