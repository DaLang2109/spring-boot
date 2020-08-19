package com.zhang.entity;

import lombok.Data;

import java.io.Reader;
import java.util.Date;
import java.util.List;

@Data
public class ArticleVO {
    private Long id;
    private String author;
    private String title;
    private String content;
    private Date createTime;
    private List<Reader> reader;
}
