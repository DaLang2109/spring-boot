package com.zhang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

//@SpringBootApplication(exclude = {
//        DataSourceAutoConfiguration.class
//})
@SpringBootApplication
@ImportResource(locations = {"classpath:test-bean.xml"})
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

}
//exclude = { DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class }