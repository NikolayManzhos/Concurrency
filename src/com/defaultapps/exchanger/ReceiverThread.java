package com.defaultapps.exchanger;

import java.util.concurrent.Exchanger;

public class ReceiverThread extends Thread {

    private final Exchanger<String> exchanger;
    private String message;

    private static final String receiverMessage = "Message from Receiver";

    ReceiverThread(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            message = exchanger.exchange(receiverMessage);
            System.out.println("Receiver: " + message);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
