package com.zhang.entity;

import lombok.Data;

import java.util.Date;

@Data
public class ArticleVO {
    private Long id;
    private String author;
    private String title;
    private String content;
    private Date createTime;
}
