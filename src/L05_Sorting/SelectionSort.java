package L05_Sorting;

import java.util.Arrays;

public class SelectionSort {
    public void sort(int[] array){
        for(int i = 0; i < array.length; i++){
            var minIndex = i;
            for(int j = i + 1; j < array.length; j++){
                if(array[j] < array[minIndex]){
                    minIndex = j;
                }
            }
            var temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }
}

class SelectionSortRunner{
    public static void main(String[] args) {
        int[] numbers = {7, 3, 1, 4, 6, 2, 3};
        var sorter = new SelectionSort();
        sorter.sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
