package com.thinking_in_java.chap11;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by wuteng on 2017/5/21.
 */
public class CollectionSequence extends AbstractCollection<String> {

    private String[] pets = {"a", "b", "c", "d", "e", "f"};

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < pets.length;
            }

            @Override
            public String next() {
                return pets[index++];
            }
        };
    }

    @Override
    public int size() {
        return pets.length;
    }


    public static void display(Iterator<String> iterator) {
        while (iterator.hasNext()) {
            String val = iterator.next();
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void display(Collection<String> collection) {
        for (String val : collection) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        CollectionSequence c = new CollectionSequence();
        display(c.iterator());
    }
}
