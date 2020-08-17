package com.zhang.getconfigfiletest;

import com.zhang.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class TestUnfineProperties {

    @Resource
    private Employee employee;

    @Test
    public void testImportYML() {
        List<String> list = employee.getNameList();
        for (String s:list){
            System.out.println(s);
        }
    }
}
