package com.threads.haircutterv1_1;

public class WaitingRoom {
    private int personsNumber = 0;
    private int hallCapacity;

    public WaitingRoom(int hallCapacity) {
        this.hallCapacity = hallCapacity;
    }

    public synchronized void cutMan() {

        while (personsNumber < 1) {
            System.out.println("----------------------------------------");
            System.out.println("The visitor wakes up the haircutter");
            System.out.println("----------------------------------------");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        personsNumber--;

        if (personsNumber == 0) {
            System.out.println("The client went to get a haircut");
            System.out.println(personsNumber + " people are in the waiting room");
            System.out.println("-----------------------------------------------");
            System.out.println("The haircutter went to have a nap.");
            System.out.println("-----------------------------------------------");
        } else {
            System.out.println("The client went to get a haircut");
            System.out.println(personsNumber + " people are in the waiting room");
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notify();
    }

    public synchronized void addPerson() {
//        if (personsNumber == 0) {
//            System.out.println("-----------------------------------------------");
//            System.out.println("The visitor wakes up the haircutterv1_1.");
//            System.out.println("-----------------------------------------------");
//        }
        while (personsNumber >= hallCapacity) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        personsNumber++;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("One more person came to the waiting room.");
        System.out.println(personsNumber + " people are in the waiting room.");
        notify();
    }
}
