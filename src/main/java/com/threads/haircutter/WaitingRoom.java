package com.threads.haircutter;

public class WaitingRoom {
    private int personsNumber = 0;
    private int hallCapacity;

    public WaitingRoom(int hallCapacity) {
        this.hallCapacity = hallCapacity;
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
        System.out.println("The client went to get a haircut.");
        System.out.println(personsNumber + " people are in the waiting room.");
        notify();
    }

    public synchronized void addPerson() {
        while (personsNumber >= hallCapacity) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        personsNumber++;
        System.out.println("One more person came to the waiting room.");
        System.out.println(personsNumber + " people are in the waiting room.");
        notify();
    }
}
