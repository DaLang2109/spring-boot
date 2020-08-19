package com.zhang.jpatest;

import com.zhang.dao.test1.Article;
import com.zhang.dao.test1.ArticleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;

@SpringBootTest
public class JpaTest {
    @Resource
    ArticleRepository articleRepository;

    @Test
    void JpaTest1(){
        Article article = Article.builder().author("张三").content("爱喝凉水").createTime(new Date()).title("爱好").build();

        System.out.println(articleRepository.save(article));
    }
}
