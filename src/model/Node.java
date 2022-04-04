package model;

public class Node<E> implements Comparable<E> {
    private E item;
    private Node<E> next;

    public Node(E element) {
        this.item = element;
        this.next = null;
    }

    public Node() {
        this.item = null;
        this.next = null;
    }

    public void setItem(E item) {
        this.item = item;
    }

    public E getItem() {
        return this.item;
    }

    public Node<E> getNext() {
        return this.next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public int compareTo(E o) {
        return ((Comparable)this.getItem()).compareTo(o);
    }

    public String toString() {
        return "{" + this.getItem();
    }
}
