package com.example.javademo.concurrency;//: concurrency/ExceptionThread.java
// {ThrowsException}

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExceptionThread implements Runnable {

    public void run() {
        throw new RuntimeException();
    }

    public static void main(String[] args) {

        try {

            ExecutorService exec = Executors.newCachedThreadPool();
            exec.execute(new ExceptionThread());

        }catch (RuntimeException e){
            System.out.println("异常输出");
        }

    }
} ///:~
