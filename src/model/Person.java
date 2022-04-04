
package model;

public class Person implements Comparable<Person> {
    public String name;
    private int currentFloor;
    public int desiredOffice;
    public boolean isOnOffice;
    private int futureFloor;

    public Person(String name, int currentFloor, int desiredOffice, boolean isOnOffice) {
        this.name = name;
        this.currentFloor = currentFloor;
        this.desiredOffice = desiredOffice;
        this.isOnOffice = isOnOffice;
    }

    public Person(Person person, int futureFloor) {
        this.futureFloor = futureFloor;
    }

    public String getName() {
        return this.name;
    }

    public int getCurrentFloor() {
        return this.currentFloor;
    }

    public int getDesiredOffice() {
        return this.desiredOffice;
    }

    public boolean isOnOffice() {
        return this.isOnOffice;
    }

    public void setOnOffice(boolean onOffice) {
        this.isOnOffice = onOffice;
    }

    public int compareTo(Person o) {
        if (this.futureFloor < o.getfutureFloor()) {
            return -1;
        } else {
            return this.futureFloor > o.getfutureFloor() ? 1 : 0;
        }
    }

    public int getfutureFloor() {
        return this.futureFloor;
    }
}
