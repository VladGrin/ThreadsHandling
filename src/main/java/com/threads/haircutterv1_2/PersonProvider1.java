package com.threads.haircutterv1_2;

public class PersonProvider1 implements Runnable {
    private WaitingRoom1 waitingRoom;
    private int personsNumber;

    public PersonProvider1(WaitingRoom1 waitingRoom, int personsNumber) {
        this.waitingRoom = waitingRoom;
        this.personsNumber = personsNumber;
    }

    public void run() {
        for (int i = 1; i < personsNumber; i++) {
            if(waitingRoom.getPersonsNumber() == 1){
                System.out.println("----------------------------------------");
                System.out.println("The visitor wakes up the haircutter");
                System.out.println("----------------------------------------");
            }
            waitingRoom.addPerson();
        }
    }
}
