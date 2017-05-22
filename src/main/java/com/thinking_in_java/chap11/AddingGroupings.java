package com.thinking_in_java.chap11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by wuteng on 2017/5/21.
 */
public class AddingGroupings {

    public static void main(String[] args) {
        Collection<Integer> collection = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        Integer[] moreInts = {6, 7, 8, 9, 10};
        Collections.addAll(collection, moreInts);
        for (Integer i :
                collection) {
            System.out.print(i + " ");
        }
        System.out.println();
        collection.addAll(Arrays.asList(moreInts));
        for (Integer i :
                collection) {
            System.out.print(i + " ");
        }
    }
}
