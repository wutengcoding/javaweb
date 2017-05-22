package com.thinking_in_java.chap11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by wuteng on 2017/5/21.
 */
public class ListIteration {

    public static void main(String[] args) {
        List<String> pets = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e", "f", "g"));
        ListIterator<String> listIterator = pets.listIterator();
        while (listIterator.hasNext()) {
            String nextVal = listIterator.next();
            System.out.print(nextVal + ", " + listIterator.nextIndex() + ", " + listIterator.previousIndex() + "; ");
        }

        System.out.println();
        listIterator = pets.listIterator(4);
        while (listIterator.hasPrevious()) {
            String preValue = listIterator.previous();
            System.out.print(preValue+" ");
        }

    }
}
