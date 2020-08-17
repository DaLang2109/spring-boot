package com.zhang.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reader {
    private String name;
    private int age;
    private String sex;
}
