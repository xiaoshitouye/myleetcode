package sort;

import java.util.Arrays;

public class bubbleSort {
    public static void main(String[] args) {
        int[] arr = {2,5,3,8,6,9,7,10,0};
        bubblesort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void bubblesort(int[] arr) {
        int len = arr.length;
        for(int i = 0; i < len - 1; i++){
            for(int j = 0; j< len - 1 - i; j++){
              if(arr[j] > arr[j + 1]){
                  swap(arr, j, j + 1);
              }
            }
        }
    }

    private static void swap(int[] arr, int j, int i) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
