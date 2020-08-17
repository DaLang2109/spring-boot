package com.zhang.controller;


import com.zhang.entity.Article;
import com.zhang.entity.Family;
import com.zhang.entity.Readeer;
import com.zhang.service.ArticleService;
import com.zhang.utill.Msg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@Slf4j
@RequestMapping("/test")
public class ArticleController {

    @Resource
    ArticleService articleService;
    /****
     * 添加文章
     * @return
     */
    @PostMapping("/article")
    public Msg AddArticle(@RequestBody Article article) {
        return Msg.success().add("article",article).add("data",articleService.getArticle(article));
    }

    /****
     * 删除文章
     * @return
     */
    /*http://localhost:8080/test/article?id=55*/
    @DeleteMapping("/article/{id}")
    public Msg DelArticle(@PathVariable("id") String id) {
        log.info("文章id:"+id);
        return Msg.success();
    }
    /*http://localhost:8080/test/article?id=55*/
    @DeleteMapping ("/article")
    public Msg DelArticleById(@RequestParam("id") String id) {
        log.info("文章?????id:"+id);
        return Msg.success();
    }
    /****
     * 修改文章
     * @return
     */
    @PutMapping ("/article")
    public Msg UpdateArticle(@RequestBody Article article) {
        if (article.getId()==null){
            System.out.println("抛出异常");
            return Msg.fail();
        }{
            log.info(article.getAuthor());
            return Msg.success();
        }
    }

    /****
     * 查询文章
     * @return
     */
    @GetMapping("/article/{id}")
    public Msg GetArticle(@PathVariable("id") String id ) {
        Readeer readeer = Readeer.builder().name("张三").sex("男").age(18).build();
        Article article = Article.builder()
                .id(id)
                .author("下雨")
                .code("10002")
                .publishingdate(new Date())
                .name("山沟皇帝")
                .readeer(readeer)
                .build();
        return Msg.success().add("article",article);
    }

    /****
     * 查询文章
     * @return
     */
    @GetMapping("/articles")
    public Msg GetArticles() {
        Readeer readeer = Readeer.builder().name("张三").sex("男").age(18).build();
        Article article = Article.builder()
                .id("id")
                .author("雨势下雨")
                .code("10002")
                .publishingdate(new Date())
                .name("山沟皇帝")
                .readeer(readeer)
                .build();
        return Msg.success().add("article",article);
    }




}