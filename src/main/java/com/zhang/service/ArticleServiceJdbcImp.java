package com.zhang.service;

import com.zhang.dao.ArticleJdbcDao;
import com.zhang.entity.Article;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ArticleServiceJdbcImp implements ArticleService {

    @Resource
    private ArticleJdbcDao articledao;

    @Resource
    JdbcTemplate primaryJdbcTemplate;

    @Resource
    JdbcTemplate secondaryJdbcTemplate;

    @Override
    @Transactional
    public void saveArticle(Article article) {
        articledao.saveArticle(article,primaryJdbcTemplate);
        articledao.saveArticle(article,secondaryJdbcTemplate);
    }

    @Override
    @Transactional
    public void updateArticle(Article article) {
        articledao.updateArticle(article,null);
    }

    @Override
    public void delArticle(Long id) {
        articledao.delArticle(id,null);
    }

    @Override
    public Article queryById(Long id) {
        return articledao.queryById(id,null);
    }

    @Override
    public List<Article> queryAll() {
        return articledao.queryAll(null);
    }
}
