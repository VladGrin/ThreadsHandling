package com.threads.haircutter;

public class PersonProvider implements Runnable {
    private WaitingRoom waitingRoom;
    private int personsNumber;
    private Thread thread;

    public PersonProvider(WaitingRoom waitingRoom, int personsNumber) {
        this.waitingRoom = waitingRoom;
        this.personsNumber = personsNumber;
        thread = new Thread(this);
        thread.start();
    }

    public void run() {
        for (int i = 1; i < personsNumber; i++) {
            waitingRoom.addPerson();
        }
    }
}
