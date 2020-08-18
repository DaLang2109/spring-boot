package com.zhang.utill;

import org.assertj.core.util.Lists;
import org.dozer.DozerBeanMapperBuilder;
import org.dozer.Mapper;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
/**
 * @author  yanping_zhang
 * @create  2020/8/18 17:44
 * @desc  将源list转换成目标list
 **/
public class DozerUtill {
    static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    public static <T> List<T> mapList(Collection sourceList, Class<T> destinationClass) {

        List destinationList = Lists.newArrayList();

        for (Iterator i$ = sourceList.iterator(); i$.hasNext(); ) {
            Object source0bject = i$.next();
            Object destinationObject = mapper.map(source0bject, destinationClass);
            destinationList.add(destinationObject);
        }
        return destinationList;
    }
}