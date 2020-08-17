package com.zhang.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@Slf4j
public class ArticleControllerTestJunit {
    //创建mock 对象
    private static MockMvc mockMvc;
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


    @BeforeAll
    static void setUp(){
        //创建测试 ArticleController 的mock对象
        mockMvc=MockMvcBuilders.standaloneSetup(new ArticleController()).build();
    }

    @Test
    public void TestSaveArticle() throws Exception {
        //执行
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders
                        .request(HttpMethod.POST, "/test/article")
                        .contentType("application/json")
                        .content(article)
        )
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$..id").value("999"))
        .andDo(print())
        .andReturn();
        mvcResult.getResponse().setCharacterEncoding("utf-8");
        log.info("返回结果:"+mvcResult.getResponse().getContentAsString());
    }

}
