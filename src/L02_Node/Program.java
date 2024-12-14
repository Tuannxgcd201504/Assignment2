package L02_Node;

class Node<T>{
    public T element;
    public Node next;
    public Node(T element){
        this.element = element;
    }
}
public class Program {
    public static void main(String[] args) {
        Node<Integer> n0 = new Node(10);
        Node<Integer> n1 = new Node(20);
        Node<Integer> n2 = new Node(30);

        n0.next = n1;

        System.out.println(n0.element); // 10
        System.out.println(n1.element); // 20

        System.out.println(n0.next.element); // 20

        n0.next.element = 50; // ~ n1.element = 50
        System.out.println(n1.element); // 50

        n1.next = n2;
        System.out.println(n0.next.next.element); // <-- 30
    }
}
