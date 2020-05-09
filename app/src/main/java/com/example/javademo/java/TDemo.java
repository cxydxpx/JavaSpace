package com.example.javademo.java;

public class TDemo<T> {

    private T a;

    public TDemo(T a) {
        this.a = a;
    }

    public void set(T a) {
        this.a = a;
    }

    public T get() {
        return a;
    }

}
