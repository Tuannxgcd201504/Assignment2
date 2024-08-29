package Assignment2;

public interface AbstractQueueADT<T> {
    void offer (T element);
    T poll();
    T peek();
    int size();
    boolean isEmpty();
}
