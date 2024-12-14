package L02_StackADT;

public interface AbstractStackADT<T> {
    void push( T element ); // Pushes an element onto the stack
    T pop( ); // Pops the top element from the stack
    T peek( ); // Peeks at the top element
    int size( ); // Gets the size of the stack
    boolean isEmpty( ); // Checks if the stack is empty
}
