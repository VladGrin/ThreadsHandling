package com.threads.haircutterv1_1;

public class PersonProvider implements Runnable {
    private WaitingRoom waitingRoom;
    private int personsNumber;

    public PersonProvider(WaitingRoom waitingRoom, int personsNumber) {
        this.waitingRoom = waitingRoom;
        this.personsNumber = personsNumber;
    }

    public void run() {
        for (int i = 1; i < personsNumber; i++) {
            waitingRoom.addPerson();
        }
    }
}
