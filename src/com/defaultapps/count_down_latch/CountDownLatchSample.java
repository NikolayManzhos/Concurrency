package com.defaultapps.count_down_latch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchSample {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        CountDownThread t1 = new CountDownThread("A", countDownLatch);
        t1.start();

        CountDownThread t2 = new CountDownThread("B", countDownLatch);
        t2.start();

        CountDownThread t3 = new CountDownThread("C", countDownLatch);
        t3.start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("All threads are done!");
    }
}
