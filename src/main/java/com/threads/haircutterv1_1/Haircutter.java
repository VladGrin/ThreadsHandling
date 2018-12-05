package com.threads.haircutterv1_1;

public class Haircutter implements Runnable {

    private WaitingRoom waitingRoom;
    private int personsNumber;

    public Haircutter(WaitingRoom waitingRoom, int personsNumber) {
        this.waitingRoom = waitingRoom;
        this.personsNumber = personsNumber;
    }

    @Override
    public void run() {
        for (int i = 1; i < personsNumber; i++) {
            waitingRoom.cutMan();
        }
    }
}
