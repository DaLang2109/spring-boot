package com.zhang.datasource;


import com.zhang.entity.ArticleVO;
import com.zhang.service.ArticleServiceJdbcImp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.util.List;


@SpringBootTest
public class DatasourceTest {
    @Autowired
    DataSource dataSource;
    @Autowired
    ArticleServiceJdbcImp articleServiceJdbcImp;

    @Test
    public void DatasourceTest1() {
        List<ArticleVO> articles = articleServiceJdbcImp.queryAll();

        System.out.println("查询id" + articles.get(0).getId());

    }
}
