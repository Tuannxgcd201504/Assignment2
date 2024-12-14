package L01_ArrayADT;

public interface AbtractList<T>{
    boolean add(T element);
    T get(int index);
    T set(int index, T element);
    T remove(int index);
    int size();
    int indexOf(T element);
    boolean contains(T element);
    boolean isEmty();
}
