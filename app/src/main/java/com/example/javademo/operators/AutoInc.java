package com.example.javademo.operators;

public class AutoInc {

    public static void main(String[] args) {

        int i = 2, j = 2;

        System.out.println("i++ = " + i++); // 2
        System.out.println("i = " + i); // 3
        System.out.println("++i = " + ++i); // 4
        System.out.println("i = " + i); // 4

        System.out.println("j-- = " + j--); // 2
        System.out.println("j = " + j); // 1
        System.out.println("--j = " + --j); // 0
        System.out.println("j = " + j); // 0

    }

}
