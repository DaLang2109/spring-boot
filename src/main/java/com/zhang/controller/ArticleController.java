package com.zhang.controller;


import com.zhang.entity.ArticleVO;
import com.zhang.service.ArticleServiceJdbcImp;
import com.zhang.utill.Msg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/test")
public class ArticleController {

    @Resource
    ArticleServiceJdbcImp articleServiceJdbcImp;

    /****
     * 添加文章
     * @return
     */
    @PostMapping("/article")
    public Msg AddArticle(@RequestBody ArticleVO articleVO) {
        articleServiceJdbcImp.saveArticle(articleVO);
        return Msg.success();
    }

    /****
     * 删除文章
     * @return
     */
    /*http://localhost:8080/test/article?id=55*/
    @DeleteMapping("/article/{id}")
    public Msg DelArticle(@PathVariable("id") Long id) {
        articleServiceJdbcImp.delArticle(id);
        return Msg.success();
    }

    /*http://localhost:8080/test/article?id=55*/
    @DeleteMapping("/article")
    public Msg DelArticleById(@RequestParam("id") Long id) {
        articleServiceJdbcImp.delArticle(id);
        return Msg.success();
    }

    /****
     * 修改文章
     * @return
     */
    @PutMapping("/article")
    public Msg UpdateArticle(@RequestBody ArticleVO articleVO) {
        if (articleVO.getId() == null) {
            System.out.println("抛出异常");
            return Msg.fail();
        }
        {
            articleServiceJdbcImp.updateArticle(articleVO);
            return Msg.success();
        }
    }

    /****
     * 查询文章
     * @return
     */
    @GetMapping("/article/{id}")
    public Msg GetArticle(@PathVariable("id") Long id) {
        return Msg.success().add("article", articleServiceJdbcImp.queryById(id));
    }

    /****
     * 查询文章
     * @return
     */
    @GetMapping("/articles")
    public Msg GetArticles() {
        return Msg.success().add("List", articleServiceJdbcImp.queryAll());
    }

}

