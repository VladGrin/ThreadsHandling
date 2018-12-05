package com.threads.haircutterv1_2;

public class Haircutter1 implements Runnable {

    private WaitingRoom1 waitingRoom;
    private int personsNumber;
    private int waitingRoomCapacity;

    public Haircutter1(WaitingRoom1 waitingRoom, int personsNumber) {
        this.waitingRoom = waitingRoom;
        this.personsNumber = personsNumber;
    }

    @Override
    public void run() {
        for (int i = 1; i < personsNumber; i++) {
            if(waitingRoom.getPersonsNumber() == 0){
                System.out.println("-----------------------------------------------");
                System.out.println("The haircutter went to have a nap.");
                System.out.println("-----------------------------------------------");
            }
            waitingRoom.cutMan();
        }
    }
}
