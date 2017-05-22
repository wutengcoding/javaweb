package com.thinking_in_java.chap11;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by wuteng on 2017/5/21.
 */
public class SetOfIntegers {

    public static void main(String[] args) {
        Random randon = new Random();
        Set<String> integers = new TreeSet<>();
        for (int i = 0; i < 10000; i++) {
            integers.add("a" + randon.nextInt(30));
        }
        System.out.println(integers);
    }
}
