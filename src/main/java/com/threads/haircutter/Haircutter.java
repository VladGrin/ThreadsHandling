package com.threads.haircutter;

public class Haircutter implements Runnable {

    private WaitingRoom waitingRoom;
    private int personsNumber;
    Thread thread;

    public Haircutter(WaitingRoom waitingRoom, int personsNumber) {
        this.waitingRoom = waitingRoom;
        this.personsNumber = personsNumber;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        for (int i = 1; i < personsNumber; i++) {
            waitingRoom.cutMan();
        }
    }
}
