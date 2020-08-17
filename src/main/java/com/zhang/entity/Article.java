package com.zhang.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@Slf4j
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class Article {
    @NotNull
    private String id;
    @Size(min=3,max=10,message = "3到10")
    private String name;
    private String code;
    //局部调时间格式
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss",timezone = "GM+8")
    private Date publishingdate ;
    private String author;
    //在不改程序中代码的情况下,修改返回字段 readeer为读者
    @JsonProperty("reader")
    private Readeer readeer;
    //当值为null时,不返回该字段
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Readeer> readerList;

}
