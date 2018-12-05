package com.threads.task9_3;

import java.util.HashMap;

public class WriterToHashMap {
    void write(HashMap<String, String> hashMap) {
        
        new Thread(() -> {
            long startTime = System.currentTimeMillis();
            for (int j = 1; j < 100; j++) {
                hashMap.put("Key" + j, "Value" + j);
            }
            long endTime = System.currentTimeMillis();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Record time to the collection HashMap for THREAD: " +
                    Thread.currentThread().getName() + " - " + (endTime - startTime) + "ms.");
        }).start();

        new Thread(() -> {
            long startTime = System.currentTimeMillis();
            for (int j = 100; j < 201; j++) {
                hashMap.put("Key" + j, "Value" + j);
            }
            long endTime = System.currentTimeMillis();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Record time to the collection HashMap for THREAD: " +
                    Thread.currentThread().getName() + " - " + (endTime - startTime) + "ms.");
        }).start();
    }
}
