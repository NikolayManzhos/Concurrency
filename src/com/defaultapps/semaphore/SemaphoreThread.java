package com.defaultapps.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreThread extends Thread {

    private final String name;
    private final Semaphore semaphore;

    SemaphoreThread(String name, Semaphore semaphore) {
        this.name = name;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        System.out.println(name + " : acquiring lock...");
        System.out.println(name + " : available Semaphore permits now: "
                + semaphore.availablePermits());

        try {
            semaphore.acquire();

            System.out.println(name + " : got the permit!");

            try {
                System.out.println(name + " : is performing operation"
                        + ", available Semaphore permits : "
                        + semaphore.availablePermits());

                Thread.sleep(10000);
            } finally {
                semaphore.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
