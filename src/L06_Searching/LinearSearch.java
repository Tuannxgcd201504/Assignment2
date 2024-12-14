package L06_Searching;

public class LinearSearch {
    public int search(int[] array, int target){
        for (int i = 0; i < array.length; i++){
            if (array[i] == target){
                return i;
            }
        }
        return -1;
    }
}

class linearSearchRunner{
    public static void main(String[] args) {
        LinearSearch runner = new LinearSearch();
        int[] numbers = {1, 3, 4, 6, 7, 11, 13, 15, 19, 20};
        int target = 21;
        int result = runner.search(numbers, target);
        if (result != -1) {
            System.out.println("Index of " + target + " at: " + (result+1));
        } else {
            System.out.println("Not found!");
        }
    }
}