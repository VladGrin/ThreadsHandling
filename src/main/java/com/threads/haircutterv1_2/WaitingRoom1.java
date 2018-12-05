package com.threads.haircutterv1_2;

public class WaitingRoom1 {
    private int personsNumber = 0;
    private int hallCapacity;

    public WaitingRoom1(int hallCapacity) {
        this.hallCapacity = hallCapacity;
    }

    public int getPersonsNumber() {
        return personsNumber;
    }

    public synchronized void cutMan() {
        while (personsNumber < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        personsNumber--;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("The client went to get a haircut.");
        System.out.println(personsNumber + " people are in the waiting room.");
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
