package com.example.javademo.java;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import static java.lang.System.out;

public class StringDemo {

    @Override
    public String toString() {
        return "StringDemo : " + super.toString() + "\n";
    }

    public static void main(String[] args){

//        test1();

//        test2();

//        test3();

//        test4();

        test5();

    }

    private static void test5() {

        out.println("-1234".matches("-?\\d+"));
        out.println("3435".matches("—|\\d+"));
        out.println("+234".matches("(-|\\+)?"));
        out.println("-".matches("-?\\d+"));

    }

    private static void test4() {

        int ii = 20;
        double ff = 30.010000;
        String ss = "hello";

        Formatter formatter = new Formatter(out);

        out.println("sum [ " + ii + " " + ff + " ]" );
        formatter.format("sum [ %s %d ]",ss,ii);

    }

    private static void test3() {
        String mango = "mango";
        String s = "abc" + mango + "def" +47;
        out.println(s);
    }

    private static void test2() {
        List<StringDemo> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(new StringDemo());
        }

        out.println(list);

    }

    private static void test1() {
        String s = "hello world";
        out.println(s);
        String copy = upper(s);
        out.println(copy);
    }

    private static String upper(String s) {
        return s.toUpperCase();
    }



}
