package L06_Searching;

public class BinarySearch {
    public int searchRec(int[] array, int target){
        return searchRec(array, target, 0, array.length-1);
    }
    private int searchRec(int[] array, int target, int left, int right){
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (array[mid] == target){
            return mid;
        }
        if(target < array[mid]){
            return searchRec(array, target, left, mid - 1);
        } else {
            return searchRec(array, target, mid + 1, right);
        }
    }


    public int search(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == target) {
                return mid;
            }

            if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}


class BinarySearchRunner {
    public static void main(String[] args) {
        BinarySearch runner = new BinarySearch();
        int[] numbers = {1, 3, 4, 6, 7, 11, 13, 15, 19, 20};
        int target = 20;
        // int result = runner.search(numbers, target);
        int result = runner.searchRec(numbers, target);

        if (result != -1) {
            System.out.println("Index of " + target + " at: " + (result+1)); // Fixed index display
        } else {
            System.out.println("Not found!");
        }
    }
}
