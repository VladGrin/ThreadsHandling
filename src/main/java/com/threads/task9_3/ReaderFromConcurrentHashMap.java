package com.threads.task9_3;

import java.util.concurrent.ConcurrentHashMap;

public class ReaderFromConcurrentHashMap {
    void read(ConcurrentHashMap<String, String> concurrentHashMap) {
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                long startTime = System.currentTimeMillis();
                for (ConcurrentHashMap.Entry<String, String> entry : concurrentHashMap.entrySet()) {
                    System.out.println("Reader ConcurrentHashMap" + Thread.currentThread().getName() + " : " +
                            entry.getKey() + " / " + entry.getValue());
                }
                long endTime = System.currentTimeMillis();
                try {
                    Thread.sleep(7000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Reading time from the collection ConcurrentHashMap for THREAD: " +
                        Thread.currentThread().getName() + " - " + (endTime - startTime) + "ms.");
            }).start();
        }
    }
}
