package com.threads.task9_3;

import java.util.concurrent.ConcurrentHashMap;

public class WriterToConcurrentHashMap {
    void write(ConcurrentHashMap<String, String> concurrentHashMap) {

        new Thread(() -> {
            long startTime = System.currentTimeMillis();
            for (int j = 1; j < 100; j++) {
                concurrentHashMap.put("Key" + j, "Value" + j);
            }
            long endTime = System.currentTimeMillis();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Record time to the collection ConcurrentHashMap for THREAD: " +
                    Thread.currentThread().getName() + " - " + (endTime - startTime) + "ms.");
        }).start();

        new Thread(() -> {
            long startTime = System.currentTimeMillis();
            for (int j = 100; j < 201; j++) {
                concurrentHashMap.put("Key" + j, "Value" + j);
            }
            long endTime = System.currentTimeMillis();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Record time to the collection ConcurrentHashMap for THREAD: " +
                    Thread.currentThread().getName() + " - " + (endTime - startTime) + "ms.");
        }).start();
    }
}
