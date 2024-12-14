package L02_LinkedList;

import java.util.NoSuchElementException;

public class SinglyLinkedList<T> implements AbstractLinkList<T> {
    private class Node<T> {
        private T element;
        private Node<T> next;
        public Node(T element){
            this.element = element;
            this.next = null;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public SinglyLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    @Override
    public void addFirst(T element) {
        Node<T> newNode = new Node<>(element);
        if(isEmpty()){
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        this.size++;
    }

    @Override
    public void addLast(T element) {
        Node<T> newNode =  new Node<>(element);
        if (isEmpty()){
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        this.size++;
    }

    @Override
    public T removeFirst() {
        if(isEmpty()){
            throw new NoSuchElementException("LinkedList is currently empty.");
        }
        T oldNodeValue = this.head.element;
        if (head == tail){
            head = tail = null;
        } else {
            Node<T> tempNode = head.next;
            this.head.next = null;
            this.head = tempNode;
            this.size--;
        }
        return oldNodeValue;
    }

    @Override
    public T removeLast() {
        if(isEmpty()){
            throw new NoSuchElementException("LinkedList is currently empty.");
        }

        T oldNodeValue = this.tail.element;

        Node<T> tempNode = head;
        if (head == tail){
            head = tail = null;
        }
        while (tempNode.next != tail){
            tempNode = tempNode.next;
        }
        tempNode.next = null;
        tail = tempNode;

        this.size--;

        return oldNodeValue;
    }

    @Override
    public T getFirst() {
        if(isEmpty()){
            throw new NoSuchElementException("LinkedList is currently empty.");
        }
        return this.head.element;
    }

    @Override
    public T getLast() {
        if(isEmpty()){
            throw new NoSuchElementException("LinkedList is currently empty.");
        }
        return this.tail.element;
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
    public String toString(){
        StringBuilder results = new StringBuilder();
        results.append("[");

        Node<T> tempNode = head;

        while(tempNode != null){
            results.append(tempNode.element);
            if(tempNode.next != null){
                results.append(", ");
            }
            tempNode = tempNode.next;
        }

        results.append("]");

        return results.toString();
    }
}

class program{
    public static void main(String[] args) {
        SinglyLinkedList mySinglyLinkedList = new SinglyLinkedList<>();

        System.out.println(mySinglyLinkedList.isEmpty());

        mySinglyLinkedList.addLast(10);
        mySinglyLinkedList.addLast(20);
        mySinglyLinkedList.addLast(30);

        mySinglyLinkedList.addFirst(40);
        mySinglyLinkedList.addLast(50);
        mySinglyLinkedList.addLast(60);
        mySinglyLinkedList.addLast(70);
        mySinglyLinkedList.addLast(80);

        System.out.println(mySinglyLinkedList);
        System.out.println(mySinglyLinkedList.removeLast()); // 80
        System.out.println(mySinglyLinkedList.removeFirst()); // 40

        System.out.println(mySinglyLinkedList.getFirst()); // 10
        System.out.println(mySinglyLinkedList.getLast());  // 70
    }
}
