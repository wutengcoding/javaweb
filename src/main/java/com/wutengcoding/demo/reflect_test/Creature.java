package com.wutengcoding.demo.reflect_test;

/**
 * Created by wuteng on 2017/5/17.
 */
public class Creature<T> {
    public void say(T t) {
        System.out.println("hi for Creature " + t);
    }

    @Override
    public String toString() {
        return "Creature{}";
    }
}
