package Ex1_Taskmanagement.TaskManagementApp6;

public interface AbstractList<T> {
    boolean add(T element);
    T remove(int index);
    T get(int index);
    T set(int index, T element);
    int size();
    int indexOf(T element);
    boolean contains(T element);
    boolean isEmpty();
}