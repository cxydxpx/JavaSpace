package com.example.javademo.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class TaskWithResult implements Callable<String> {
    private int id;

    public TaskWithResult(int id) {
        System.out.println(Thread.currentThread().getName());
        this.id = id;
    }

    public String call() {
        System.out.println(Thread.currentThread().getName());
        return "result of TaskWithResult " + id;
    }
}

public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        try {
            Future<String> submit = exec.submit(new TaskWithResult(9));
            String s = submit.get();
            System.out.println(s);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            exec.shutdown();
        }
    }
}
