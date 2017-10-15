package com.defaultapps.cyclic_barrier;

import java.util.List;

public class FinalThread extends Thread {

    private final List<Integer> resultList;

    FinalThread(List<Integer> resultList) {
        this.resultList = resultList;
    }

    @Override
    public void run() {
        int sum = 0;
        for (Integer item : resultList) {
            System.out.println(item);
            sum += item;
        }
        System.out.println("Sum: " + sum);
    }
}
