package com.defaultapps.cyclic_barrier;

import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierThread extends Thread {

    private final String name;
    private final CyclicBarrier cyclicBarrier;
    private final List<Integer> resultList;
    private final Random random;

    CyclicBarrierThread(String name,
                        CyclicBarrier cyclicBarrier,
                        List<Integer> resultList,
                        Random random) {
        this.name = name;
        this.cyclicBarrier = cyclicBarrier;
        this.resultList = resultList;
        this.random = random;
    }

    @Override
    public void run() {
        System.out.println("Thread " + name +" is running");
        resultList.add(random.nextInt(10));
        try {
            System.out.println("Thread " + name + " is waiting");
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
