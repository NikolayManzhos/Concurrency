package com.defaultapps.cyclic_barrier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierSample {

    public static void main(String[] args) {
        int THREAD_COUNT = 3;
        List<Integer> resultList = Collections.synchronizedList(new ArrayList<>());
        Random random = new Random();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(THREAD_COUNT, new FinalThread(resultList));

        CyclicBarrierThread t1 = new CyclicBarrierThread("A", cyclicBarrier, resultList, random);
        t1.start();

        CyclicBarrierThread t2 = new CyclicBarrierThread("B", cyclicBarrier, resultList, random);
        t2.start();

        CyclicBarrierThread t3 = new CyclicBarrierThread("C", cyclicBarrier, resultList, random);
        t3.start();
    }
}
