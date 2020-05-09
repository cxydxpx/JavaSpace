package com.example.javademo.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LiftOffCopyThread extends Thread {


    public LiftOffCopyThread() {
        System.out.println(Thread.currentThread().getName() + " Runable start");
    }

    private int i = 0;

    @Override
    public void run() {
//        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName()  + " Runable run : " + ++i);
            Thread.yield();
//        }

        System.out.println(Thread.currentThread().getName() + " Runable end");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new LiftOffCopyThread().start();
        }
    }
}
