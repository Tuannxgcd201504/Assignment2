package L02_LinkedList;

public interface AbstractLinkList<T> {
    void addFirst(T element);
    void addLast(T element);
    T removeFirst();
    T removeLast();
    T getFirst( ); // ~ peek > head
    T getLast( ); // ~ peek > tail
    int size( );
    boolean isEmpty( );
}
