package com.lz.controller;

import java.lang.reflect.ParameterizedType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * 通过传入的泛型获取bean
 * @author Administrator
 *
 * @param <T>
 */
public class BaseController<T> {
    Class<T> fType=(Class <T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];;
    ApplicationContext act=new ClassPathXmlApplicationContext("spring-mybatis.xml");
    T service=act.getBean(fType);
}
