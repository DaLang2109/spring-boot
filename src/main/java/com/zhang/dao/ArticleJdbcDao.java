package com.zhang.dao;


import com.zhang.entity.Article;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Repository
public class ArticleJdbcDao {

    @Resource
    private JdbcTemplate primaryJdbcTemplate;

    //保存文章
    @Transactional
    public void saveArticle (Article article,JdbcTemplate jdbcTemplate){
        if(jdbcTemplate == null){
            jdbcTemplate=primaryJdbcTemplate;
        }
        jdbcTemplate.update("INSERT INTO article (author,title,content,create_time)VALUES(?,?,?,?)",
                article.getAuthor(),
                article.getTitle(),
                article.getContent(),
                article.getCreateTime()
        );
    }

    //删除文章  DELETE FROM  article where id='1'
    public void delArticle (Long id,JdbcTemplate jdbcTemplate){
        if(jdbcTemplate == null){
            jdbcTemplate=primaryJdbcTemplate;
        }
        jdbcTemplate.update("DELETE FROM article where id= ? ",
                id
        );
    }

    //更新文章
    public void updateArticle (Article article,JdbcTemplate jdbcTemplate){
        if(jdbcTemplate == null){
            jdbcTemplate=primaryJdbcTemplate;
        }
        jdbcTemplate.update("UPDATE article set author=?,title=?,content=?,create_time=? where id = ?",
                article.getAuthor(),
                article.getTitle(),
                article.getContent(),
                article.getCreateTime(),
                article.getId()
        );
    }

    //查询单个文章
    public Article queryById (Long id,JdbcTemplate jdbcTemplate){
        if(jdbcTemplate == null){
            jdbcTemplate=primaryJdbcTemplate;
        }
        return jdbcTemplate.queryForObject("SELECT * FROM article WHERE id = ?",new Object[]{id},
                new BeanPropertyRowMapper<>(Article.class) );
    }

    //查询所有文章
    public List<Article> queryAll (JdbcTemplate jdbcTemplate){
        if(jdbcTemplate == null){
            jdbcTemplate=primaryJdbcTemplate;
        }
        return jdbcTemplate.query("SELECT * FROM article",new BeanPropertyRowMapper<>(Article.class));
    }

}
