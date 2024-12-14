package L05_Sorting;

import java.util.Arrays;

public class BubbleSort {
    public void sort(int[] array){
        for (int i = 0; i < array.length; i++){
            for (int j = 1; j < array.length; j++){
                if(array[j] < array[j-1]){
                    var temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
    }
}

class BubbleSortRunner{
    public static void main(String[] args) {
        int[] numbers = {7, 3, 1, 4, 6, 2, 3};
        var sorter = new SelectionSort();
        sorter.sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}