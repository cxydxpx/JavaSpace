package com.example.javademo.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SleepingTask extends LiftOff {

    public void run() {
        try {
            int i = (int) (Math.random() * 10 + 1);
            System.out.println(Thread.currentThread().getName() + "睡眠时间：" + i);
            TimeUnit.SECONDS.sleep(i);
        } catch (InterruptedException e) {
            System.err.println("Interrupted");
        }

    }


    public static void main(String[] args) {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        SleepingTask sleepingTask = new SleepingTask();
        for (int i = 0; i < 5; i++)
            exec.execute(sleepingTask);
        exec.shutdown();
    }
}