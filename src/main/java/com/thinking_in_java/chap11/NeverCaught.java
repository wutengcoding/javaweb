package com.thinking_in_java.chap11;

/**
 * Created by wuteng on 2017/5/21.
 */
public class NeverCaught {
    static void f() {
        throw new RuntimeException("From f()");
    }

    static void g() {
        f();
    }

    public static void main(String[] args) {
        g();
    }
}
