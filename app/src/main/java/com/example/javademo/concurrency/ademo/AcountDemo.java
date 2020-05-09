package com.example.javademo.concurrency.ademo;

import java.util.concurrent.TimeUnit;

class RunableA implements Runnable {

    Acount acount;

    public RunableA(Acount acount) {
        this.acount = acount;
    }

    @Override
    public void run() {

            double balance = acount.getBalance();
            System.out.println("1  ==  " + balance);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("3  ==  " + balance);

            acount.setBalance(balance + 20);

            System.out.println("存钱者：" + acount.getBalance());
    }
}

class RunableB implements Runnable {

    private Acount acount;

    public RunableB(Acount acount) {
        this.acount = acount;
    }

    @Override
    public void run() {
            double balance = acount.getBalance();
            System.out.println("2  ==  " + balance);

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("4  ==  " + balance);

            acount.setBalance(balance - 20);

            System.out.println("取钱者：" + acount.getBalance());
    }
}

public class AcountDemo {

    public static void main(String[] args) {
        Acount acount = new Acount();
        new Thread(new RunableA(acount)).start();
        new Thread(new RunableB(acount)).start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("最终：" + acount.getBalance());
    }

}

class Acount {
    private double balance = 100;

    public synchronized double getBalance() {
        return balance;
    }

    public synchronized void setBalance(double balance) {
        this.balance = balance;
    }
}