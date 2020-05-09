package com.example.javademo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

class MyThread extends Thread {

    @Override
    public void run() {
        long beginTime = System.currentTimeMillis();
        int count = 0;
        for (int i = 0; i < 50000000; i++) {
            count = count + (i + 1);
            Thread.yield();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("用时：" + (endTime - beginTime) + " 毫秒！");
    }
}


public class ThreadDemo {


    public static void main(String[] args) {
        final ThreadDemo threadDemo = new ThreadDemo();

        String s1 = new String("aaa");
        String s2 = new String("aaa");
        System.out.println(s1 == s2);           // false
        String s3 = s1.intern();
        String s4 = s1.intern();
        System.out.println(s3 == s4);

        List<String> mlist = new ArrayList<String>();

        List<String> list = new ArrayList<>();
        List<String> synList = Collections.synchronizedList(list);

    }
}
