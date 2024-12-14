package L01_GenericClass;

class BoxInt{
    private int x;
    public BoxInt(int x){
        this.x = x;
    }
}

class BoxString{
    private String s;
    public BoxString(String s){
        this.s = s;
    }
}

class Box<T>{
    private T element;
    public Box(T element){
        this.element = element;
    }
}

public class GenericClassExample {
    public static void main(String[] args) {
        BoxInt b1 = new BoxInt(5);
        BoxString b2 = new BoxString("hello");

        Box<Integer> b3 = new Box<>(5);
        Box<String> b4 = new Box<>("hello");
        Box<Double> b5 = new Box<>(3.14);
    }
}