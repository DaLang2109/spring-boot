package com.zhang.getconfigfiletest;

import com.zhang.entity.Family;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author yanping_zhang
 * @create 2020/8/16 17:47
 * @desc 新版本中, 如果在用juint 4,需要加@RunWith(SpringRunner.class) 这不需要否则将会被忽视掉这个注解.
 **/
@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
//@ExtendWith(SpringExtension.class)
//@RunWith(SpringRunner.class)
public class TestYmlProperties {

    @Resource
    Family family;

    @Test
    public void testImportYML() {
        System.out.println(family);
    }


}
