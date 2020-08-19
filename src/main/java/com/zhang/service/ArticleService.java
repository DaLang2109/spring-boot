package com.zhang.service;

import com.zhang.entity.ArticleVO;

import java.util.List;

public interface ArticleService {

    public void saveArticle(ArticleVO article);

    public void updateArticle(ArticleVO article);

    public void delArticle(Long id);

    public ArticleVO queryById(Long id);

    public List<ArticleVO> queryAll();
}
