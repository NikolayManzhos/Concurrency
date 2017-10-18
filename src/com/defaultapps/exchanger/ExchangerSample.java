package com.defaultapps.exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerSample {

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();

        new ProducerThread(exchanger).start();
        new ReceiverThread(exchanger).start();
    }
}
