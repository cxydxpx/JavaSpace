package com.example.javademo.concurrency.ademo;

import java.util.concurrent.TimeUnit;

class TestRunable implements Runnable {

    private Account account;

    public TestRunable(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        int price = account.getPrice();
        price++;
        account.setPrice(price);
        System.out.println("账户余额: " + account.getPrice() + " " + Thread.currentThread().getName());
    }
}


public class TestSys implements Runnable {

    private int count = 10;

    public static void main(String[] args) {

        TestSys testSys = new TestSys();
        for (int i = 0; i < 10; i++) {
            new Thread(testSys).start();
        }

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("最后结果： " + testSys.count);


    }

    @Override
    public void run() {
        System.out.println("当前 1 ：" + count + "  " + Thread.currentThread().getName());

        for (int i = 0; i < 2000; i++) {

        }
        count--;
        System.out.println("当前 2 ：" + count + "  " + Thread.currentThread().getName());
    }
}

class Account {

    public int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

