package L01_ArrayADT;

import java.util.Arrays;


public class ArrayListADT<T> implements AbtractList<T>{

    private  static final int DEFAULT_CAPACITY = 5;
    private T[] elements;

    private int size = 0;

    public ArrayListADT(){
        elements = (T[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public boolean add(T element) {

        if (size == elements.length){
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
        elements[size] = element;
        size++;
        return false;
    }

    @Override
    public T get(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index of " + index + " out of bound");
        }
        return elements[index];
    }


    @Override
    public T set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index of " + index + " out of bound");
        }
        T oldElement = elements[index];
        elements[index] = element;
        return oldElement;
    }

    @Override
    public T remove(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index out of bound: " + index + " out of size");
        }

        T oldElement = elements[index];

        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
        elements[size] = null;

        if(size < elements.length / 3){
            elements = Arrays.copyOf(elements, elements.length / 2);
        }
        return oldElement;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int indexOf(T element) {
        for (int i = 0; i < size - 1; i++) {
            if(elements[i] == element){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(T element) {
//        for (int i = 0; i < size - 1; i++) {
//            if(elements[i] == element){
//                return true;
//            }
//        }
        if (indexOf(element) != -1){
            return true;
        }
        return false;
    }

    @Override
    public boolean isEmty() {
        if (size == 0){
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        StringBuilder results = new StringBuilder();
        results.append("[");
        for (int i = 0; i < size; i++) {
            results.append(elements[i]);
            if (i < size-1) {
                results.append(", ");
            }
        }
        results.append("]");
        return results.toString();
    }
}

class ArrayListADTExample{
    public static void main(String[] args){
        ArrayListADT<Integer> intArrayList = new ArrayListADT();
        intArrayList.add(10);
        intArrayList.add(20);
        intArrayList.add(30);
        intArrayList.add(40);
        intArrayList.add(50);
        intArrayList.add(60);

        System.out.println(intArrayList.get(0));
        System.out.println(intArrayList.get(5));
        //System.out.println(intArrayList.get(6));
        intArrayList.set(3, 80);

        intArrayList.remove(0);
        intArrayList.remove(0);
        intArrayList.remove(0);
        intArrayList.remove(0);
        intArrayList.remove(0);
        intArrayList.remove(0);

        intArrayList.add(10);
        intArrayList.add(20);
        intArrayList.add(30);
        intArrayList.add(40);
        intArrayList.add(50);
        intArrayList.add(60);

        System.out.println(intArrayList.contains(40));
        System.out.println(intArrayList.contains(80));

        System.out.println(intArrayList.isEmty());
        System.out.println(intArrayList.indexOf(40));
        System.out.println(intArrayList.indexOf(80));

        System.out.println(intArrayList);
        ArrayListADT<String> stringArrayListADT = new ArrayListADT<>();
        stringArrayListADT.add("hello");
        stringArrayListADT.add("world");
        stringArrayListADT.add("welcome");
        stringArrayListADT.add("bye");
        System.out.println(stringArrayListADT);

        ArrayListADT<Book> bookArrayListADT = new ArrayListADT<>();
        bookArrayListADT.add(new Book("Conan"));
        bookArrayListADT.add(new Book("Greenwich Guideline"));
        System.out.println(bookArrayListADT);
    }
}

class Book{
    private String title;
    public Book(String title){
        this.title = title;
    }

    @Override
    public String toString(){
        return this.title;
    }
}