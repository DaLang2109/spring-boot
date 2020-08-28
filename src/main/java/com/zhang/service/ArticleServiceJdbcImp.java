package com.zhang.service;

import com.zhang.dao.test1.Article;
import com.zhang.dao.test1.ArticleRepository;
import com.zhang.dao.test2.Messge;
import com.zhang.dao.test2.MessgeRepository;
import com.zhang.entity.ArticleVO;
import com.zhang.utill.DozerUtill;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceJdbcImp {

    @Resource
    ArticleRepository articleRepository;
    @Resource
    MessgeRepository messgeRepository ;

    @Resource
    private Mapper dozerMapper;

    @javax.transaction.Transactional
    public void saveArticle(ArticleVO articleVO) {
        Article article = dozerMapper.map(articleVO, Article.class);
        Messge messge = Messge.builder().name("返回提示信息登记").content("一级警告!!!!").build();

        messgeRepository.save(messge);
        articleRepository.save(article);
        
//        int i=10/0;
    }

    
    @Transactional
    public void updateArticle(ArticleVO articleVO) {
        Article article = dozerMapper.map(articleVO, Article.class);
        articleRepository.save(article);
    }

    
    public void delArticle(Long id) {
        articleRepository.deleteById(id);
    }

    
    public ArticleVO queryById(Long id) {
        Optional<Article> article = articleRepository.findById(id);
        return dozerMapper.map(article,ArticleVO.class);
    }

    
    public List<ArticleVO> queryAll() {
        List<Article> articleList = articleRepository.findAll();
        return DozerUtill.mapList(articleList,ArticleVO.class);
    }
}
