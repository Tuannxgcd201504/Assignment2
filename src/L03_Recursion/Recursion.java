package L03_Recursion;

public class Recursion {
    public static void main(String[] args) {
        printNumbersRecursion(5);
    }

    private static void printNumbersRecursion(int x){
        if (x == 0){
            return;
        }

        System.out.print(x + " ");
        printNumbersRecursion(x - 1);
        System.out.print(x + " ");
    }
}
