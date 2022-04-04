
package model;

import java.util.ArrayList;

public class Passengers extends Queue<Person> {

    public Queue<Person> passengers;

    public Passengers(ArrayList<Person> persons) {
        passengers = new Queue<Person>();

        for(int i = 0; i < persons.size(); ++i) {
            passengers.enqueue(persons.get(i));
        }

    }

    public Person dequeueMinPriority(int currentFloor) {
        Person toOut = null;
        Node<Person> aux2 = new Node();

        for(Node auxh = this.head; auxh != null; auxh = auxh.getNext()) {
            if (((Person)auxh.getItem()).getfutureFloor() >= currentFloor) {
                aux2.setNext(auxh.getNext());
                toOut = (Person)auxh.getItem();
                break;
            }

            aux2 = auxh;
        }

        return toOut;
    }

    public Person dequeueMaxPriority(int currentFloor) {
        Person toOut = null;
        Node<Person> aux2 = new Node();

        for(Node auxh = this.head; auxh != null; auxh = auxh.getNext()) {
            if (((Person)auxh.getItem()).getfutureFloor() < currentFloor) {
                aux2.setNext(auxh.getNext());
                toOut = (Person)auxh.getItem();
                break;
            }

            aux2 = auxh;
        }

        return toOut;
    }
}
