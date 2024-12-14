package Assignment2;

import java.util.NoSuchElementException;

public class QueueADT<T> implements AbstractQueueADT<T> {
    private class Node<T> {
        private T element;
        private Node<T> next;
        public Node(T element){
            this.element = element;
            this.next = null;
        }
    }
    private int size;
    private Node<T> head;
    private Node<T> tail;

    public QueueADT(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void offer(T element) {
        Node<T> newNode = new Node<>(element);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        this.size++;
    }

    @Override
    public T poll() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is currently empty.");
        }
        T oldNodeValue = this.head.element;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        this.size--;
        return oldNodeValue;
    }

    public T getOrder(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.element;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is currently empty.");
        }
        return this.head.element;
    }

    @Override
    public int size() {

        return this.size;
    }

    @Override
    public boolean isEmpty() {

        return this.size == 0;
    }

    @Override
    public String toString() {
        StringBuilder results = new StringBuilder();
        Node<T> tempNode = head;
        int index = 1;

        while (tempNode != null) {
            results.append("Order ").append(index).append(":\n");
            results.append(tempNode.element.toString());
            results.append("\n"); // Add an empty line for better readability
            tempNode = tempNode.next;
            index++;
        }

        return results.toString();
    }
}

