package com.defaultapps.exchanger;

import java.util.concurrent.Exchanger;

public class ProducerThread extends Thread {

    private final Exchanger<String> exchanger;
    private String message;

    private static final String producerMessage = "Message from Producer";

    ProducerThread(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            message = exchanger.exchange(producerMessage);
            System.out.println("Producer: " + message);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
