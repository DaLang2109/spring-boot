package com.zhang.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

@Data
@Configuration
@PropertySource(value = "classpath:test-unrule.properties", encoding = "utf-8")
public class Employee {

    @Value("#{'${employee.name}'.split('\\|')}")
    private List<String> nameList;

    @Value("#{'${employee.name}'.split('\\|' )[0]}")
    private String firstEmployeeName;
//
//    @Value(value ="#{'${employee.age}'}")
//    private Map<String, Integer> map;

//    @Value("#{'${employee.age}'")
//    private Map<String, Integer> employeeAge;
    //@Value ( "#{${employee.age}.two}")
//    @Value("#{${employee.age}['two']}") //这样写也可以
//    private String employeeAgeTwo;
//    @Value("#{${employee.age}['five'] ?: 31}")
//    private Integer ageWithDefaultValue;
    @Value("#{systemProperties['java.home']}")
    private String javaHome;
    @Value("#{systemProperties['user.dir']}")
    private String userDir;

}
