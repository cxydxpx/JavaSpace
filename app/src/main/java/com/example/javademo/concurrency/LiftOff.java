package com.example.javademo.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class LiftOff implements Runnable {

    protected int countDown = 10; // Default
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOff() {
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" +
                (countDown > 0 ? countDown : "Liftoff!") + "),     ";
    }

    public void run() {
//        try {
            while (countDown-- > 0) {
                System.out.print(status());
//                Thread.yield();
//                TimeUnit.SECONDS.sleep(1);
            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


    }


    public static void main(String[] args) {

//        for (int i = 0; i < 5; i++) {
//            Thread thread = new Thread(new LiftOff());
//            thread.start();
//        }
//        System.out.println("waiting for liftoff");

        ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorService executorService2 = Executors.newFixedThreadPool(3);
        ExecutorService executorService3 = Executors.newSingleThreadExecutor();
        ExecutorService executorService4 = Executors.newScheduledThreadPool(4);
        for (int i = 0; i < 5; i++) {
            executorService.execute(new LiftOff());
        }
        executorService.shutdown();
    }

} ///:~