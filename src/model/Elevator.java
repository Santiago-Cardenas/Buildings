package model;

import java.util.ArrayList;

public class Elevator {
    private Passengers passengers;
    private boolean rising = true;

    public Elevator(Passengers passengers)
    {
        rising = true; //  El ascensor empieza en el primer piso
        this.passengers= passengers;
    }
    public ArrayList<Person> movements(int floorsNum)
    {
        ArrayList<Person> toOut = new ArrayList<Person>();
        if(rising)
        {
            for(int i = 1; i <= floorsNum; i++ )
            {
                toOut.add(passengers.dequeueMinPriority(i));
            }
            rising = false;
        }
        else {
            for(int i = floorsNum; i >= 1; i++ )
            {
                toOut.add(passengers.dequeueMaxPriority(i));
            }
        }
        return toOut;
    }

    public Passengers getPassengers() {
        return this.passengers;
    }
}