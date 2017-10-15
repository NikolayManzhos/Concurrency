package com.defaultapps.count_down_latch;

import java.util.concurrent.CountDownLatch;

public class CountDownThread extends Thread {

    private final String name;
    private final CountDownLatch countDownLatch;

    CountDownThread(String name, CountDownLatch countDownLatch) {
        this.name = name;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            System.out.println("Thread " + name + " is now running");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Thread " + name + " is finishing");
            countDownLatch.countDown();
        }
    }
}
