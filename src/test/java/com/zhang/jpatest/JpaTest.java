package com.zhang.jpatest;

import com.zhang.dao.test1.Article;
import com.zhang.dao.test1.ArticleRepository;
import com.zhang.dao.test2.Messge;
import com.zhang.dao.test2.MessgeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

@SpringBootTest
@Transactional
public class JpaTest {
    @Resource
    ArticleRepository articleRepository;

    @Resource
    MessgeRepository messgeRepository ;

    @Test
    void JpaTest1(){
        Article article = Article.builder().author("张三").content("爱喝凉水").createTime(new Date()).title("爱好").build();
        Messge messge = Messge.builder().content("警告").name("提示信息").build();
        System.out.println(messgeRepository.save(messge));
        System.out.println(articleRepository.save(article));
        int o=10/0;
    }
}
