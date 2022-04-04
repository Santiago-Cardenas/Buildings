
package model;

public class Queue<E> {
    protected Node<E> head;
    protected Node<E> tale;
    protected int size;

    public Queue() {
        this.head = this.tale = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public int size() {
        return this.size;
    }

    public void enqueue(E e) {
        Node<E> node = new Node(e);
        if (this.isEmpty()) {
            this.head = node;
        } else {
            this.tale.setNext(node);
        }

        this.tale = node;
        ++this.size;
    }

    public E dequeue() {
        E aux = this.head.getItem();
        this.head = this.head.getNext();
        --this.size;
        return aux;
    }

    public E getHead() {
        return this.isEmpty() ? null : this.head.getItem();
    }
}
