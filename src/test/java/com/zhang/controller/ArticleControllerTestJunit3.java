package com.zhang.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhang.entity.Article;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@Slf4j
@AutoConfigureMockMvc
@SpringBootTest
//@WebMvcTest(ArticleController.class)可以替换@SpringBootTest 更加轻量,SpringBootTest是将所有bean注入进来
@ExtendWith(SpringExtension.class)
public class ArticleControllerTestJunit3 {

    //创建mock 对象
    @Resource
    private MockMvc mockMvc;
    @MockBean
    private com.zhang.service.ArticleServiceJdbcImp ArticleServiceJdbcImp;
/*重点*/
    @Test
    public void TestSaveArticle() throws Exception {
        String article=" {\n" +
                "    \"id\": \"999\",\n" +
                "    \"name\": \"山沟皇帝的宝宝\",\n" +
                "    \"code\": \"10002\",\n" +
                "    \"publishingdate\": \"2020/08/14 11:23:24\",\n" +
                "    \"author\": \"雨势下雨\",\n" +
                "    \"reader\": {\n" +
                "        \"name\": \"张三\",\n" +
                "        \"age\": 18,\n" +
                "        \"sex\": \"男\"\n" +
                "    }\n" +
                " }";

        //打桩
        ObjectMapper mapper = new ObjectMapper();
        Article article2 = mapper.readValue(article, Article.class);
        when(ArticleServiceJdbcImp.queryById(article2.getId()));
        //执行
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders
                        .request(HttpMethod.POST, "/test/article")
                        .contentType("application/json")
                        .content(article)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print())
                .andReturn();
        mvcResult.getResponse().setCharacterEncoding("utf-8");
        log.info("返回结果:"+mvcResult.getResponse().getContentAsString());
    }

}
