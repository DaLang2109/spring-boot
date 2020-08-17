package com.zhang.controller;


import com.zhang.entity.Article;
import com.zhang.service.ArticleServiceImp;
import com.zhang.utill.Msg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/test")
public class ArticleController {

    @Resource
    ArticleServiceImp articleServiceImp;

    /****
     * 添加文章
     * @return
     */
    @PostMapping("/article")
    public Msg AddArticle(@RequestBody Article article) {
        articleServiceImp.saveArticle(article);
        return Msg.success();
    }

    /****
     * 删除文章
     * @return
     */
    /*http://localhost:8080/test/article?id=55*/
    @DeleteMapping("/article/{id}")
    public Msg DelArticle(@PathVariable("id") Long id) {
        articleServiceImp.delArticle(id);
        return Msg.success();
    }

    /*http://localhost:8080/test/article?id=55*/
    @DeleteMapping("/article")
    public Msg DelArticleById(@RequestParam("id") Long id) {
        articleServiceImp.delArticle(id);
        return Msg.success();
    }

    /****
     * 修改文章
     * @return
     */
    @PutMapping("/article")
    public Msg UpdateArticle(@RequestBody Article article) {
        if (article.getId() == null) {
            System.out.println("抛出异常");
            return Msg.fail();
        }
        {
            articleServiceImp.updateArticle(article);
            return Msg.success();
        }
    }

    /****
     * 查询文章
     * @return
     */
    @GetMapping("/article/{id}")
    public Msg GetArticle(@PathVariable("id") Long id) {
        return Msg.success().add("article", articleServiceImp.queryById(id));
    }

    /****
     * 查询文章
     * @return
     */
    @GetMapping("/articles")
    public Msg GetArticles() {
        return Msg.success().add("List", articleServiceImp.queryAll());
    }

}

//    ArrayList<Reader> arrayList = new ArrayList<>();
//        arrayList.add(Reader.builder().name("张三").sex("男").age(18).build());
//                arrayList.add(Reader.builder().name("李思思").sex("女").age(23).build());
//
//                Article article = Article.builder()
//                .id(id)
//                .author("下雨")
//                .createTime(new Date())
//                .title("山沟皇帝")
//                .readerList(arrayList)
//                .build();