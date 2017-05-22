package com.thinking_in_java.chap11;

/**
 * Created by wuteng on 2017/5/21.
 */
public class WhoCalled {
    static void f() {
        try {
            throw new Exception();
        } catch (Exception e) {
//            e.printStackTrace();
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement s : stackTrace) {
                System.out.println(s.getMethodName());
            }
        }
    }

    static void g() {
        f();
    }

    static void h() {
        g();
    }

    public static void main(String[] args) {
        f();
        System.out.println("************");
        g();
        System.out.println("************");
        h();
    }
}
