package com.example.javademo.concurrency;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainThread {

    public static void main(String[] args) {


        try {
            Test launch = new Test();
            launch.run();
            TimeUnit.SECONDS.sleep(5);

            Test launch2 = new Test();
            launch2.run();

            TimeUnit.SECONDS.sleep(5);
            Test launch3 = new Test();
            launch3.run();


        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}

class Test {

    private static int value = 0;
    private final int i = value;

    public void run() {
        value++;


        String ll = "33";

        System.out.println(i);


    }
}
