package com.zhang.getconfigfiletest;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.Resource;


@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class TestXmlProperties {
    @Resource
    private ConfigurableApplicationContext ioc;
    @Test
    public void testImportXML() {
        System.out.println(ioc.getBean("Reader").toString());
        //Reader(readername=读者)
    }
}
