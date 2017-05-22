package com.thinking_in_java.chap11;

/**
 * Created by wuteng on 2017/5/21.
 */
public class TestFillInStackTrace {
    public static void main(String[] args) {
        B b = new B();
        System.out.println(b.f());
    }
}

class A {
    Object f() {
        return this;
    }
}

class B extends A {
    @Override
    Object f() {
        return super.f();
    }
}
