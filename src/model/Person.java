package model;

public class Person {

    public String name;
    private int currentFloor;
    public int desiredOffice;
    public boolean isOnOffice;

    public Person(String name,int currentFloor, int desiredOffice, boolean isOnOffice) {
        this.name = name;
        this.currentFloor = currentFloor;
        this.desiredOffice = desiredOffice;
        this.isOnOffice = isOnOffice;
    }

    public String getName() {
        return name;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public int getDesiredOffice() {
        return desiredOffice;
    }

    public boolean isOnOffice() {
        return isOnOffice;
    }

    public void setOnOffice(boolean onOffice) {
        isOnOffice = onOffice;
    }

}
