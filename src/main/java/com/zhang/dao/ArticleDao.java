package com.zhang.dao;


import com.zhang.entity.Article;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class ArticleDao {

    @Resource
    private JdbcTemplate jdbcTemplate;

    //保存文章
    public void saveArticle (Article article){
        jdbcTemplate.update("INSERT INTO article (author,title,content,create_time)VALUES(?,?,?,?)",
                article.getAuthor(),
                article.getTitle(),
                article.getContent(),
                article.getCreateTime()
        );
    }

    //删除文章  DELETE FROM  article where id='1'
    public void delArticle (Long id){
        jdbcTemplate.update("DELETE FROM article where id= ? ",
                id
        );
    }

    //更新文章
    public void updateArticle (Article article){
        jdbcTemplate.update("UPDATE article set author=?,title=?,content=?,create_time=? where id = ?",
                article.getAuthor(),
                article.getTitle(),
                article.getContent(),
                article.getCreateTime(),
                article.getId()
        );
    }

    //查询单个文章
    public Article queryById (Long id){

        return jdbcTemplate.queryForObject("SELECT * FROM article WHERE id = ?",new Object[]{id},
                new BeanPropertyRowMapper<>(Article.class) );
    }

    //查询所有文章
    public List<Article> queryAll (){
        return jdbcTemplate.query("SELECT * FROM article",new BeanPropertyRowMapper<>(Article.class));
    }

}
