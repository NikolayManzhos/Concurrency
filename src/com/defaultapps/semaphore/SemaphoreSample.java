package com.defaultapps.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreSample {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(4);
        SemaphoreThread t1 = new SemaphoreThread("A", semaphore);
        t1.start();

        SemaphoreThread t2 = new SemaphoreThread("B", semaphore);
        t2.start();

        SemaphoreThread t3 = new SemaphoreThread("C", semaphore);
        t3.start();

        SemaphoreThread t4 = new SemaphoreThread("D", semaphore);
        t4.start();

        SemaphoreThread t5 = new SemaphoreThread("F", semaphore);
        t5.start();
    }
}
