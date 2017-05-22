package com.wutengcoding.demo.reflect_test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by wuteng on 2017/5/17.
 */
public class Test {
    public static void main(String[] args) {
        Class<? super Person> superclass = Person.class.getSuperclass();
        System.out.println(superclass);
//        带泛型的父类
        Type genericSuperclass = Person.class.getGenericSuperclass();
        System.out.println(genericSuperclass);

        // 获取父类的泛型
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        Type[] typeArgs = parameterizedType.getActualTypeArguments();
        System.out.println(typeArgs[0]);
        System.out.println(((Class)typeArgs[0]).getName());
    }
}
