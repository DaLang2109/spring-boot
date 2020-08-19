package com.zhang.service;

import com.zhang.dao.test1.ArticleRepository;
import com.zhang.dao.test1.Article;
import com.zhang.entity.ArticleVO;
import com.zhang.utill.DozerUtill;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceJdbcImp implements ArticleService {

    @Resource
    ArticleRepository articleRepository;

    @Resource
    private Mapper dozerMapper;

    @Override
    @Transactional
    public void saveArticle(ArticleVO articleVO) {
        Article article = dozerMapper.map(articleVO, Article.class);
        articleRepository.save(article);
    }


    @Override
    @Transactional
    public void updateArticle(ArticleVO articleVO) {
        Article article = dozerMapper.map(articleVO, Article.class);
        articleRepository.save(article);
    }

    @Override
    public void delArticle(Long id) {
        articleRepository.deleteById(id);
    }

    @Override
    public ArticleVO queryById(Long id) {
        Optional<Article> article = articleRepository.findById(id);
        return dozerMapper.map(article,ArticleVO.class);
    }

    @Override
    public List<ArticleVO> queryAll() {
        List<Article> articleList = articleRepository.findAll();
        return DozerUtill.mapList(articleList,ArticleVO.class);
    }
}
