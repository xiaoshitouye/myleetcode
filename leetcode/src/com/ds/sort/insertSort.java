package sort;

import java.util.Arrays;

public class insertSort {
    public static void main(String[] args) {
        int[] arr = {2,5,3,8,6,9,7,10,0};
        insertsort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertsort(int[] arr) {
        int len = arr.length;
        for(int i = 1; i < len; i++){
            for(int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--){
              swap(arr, j, j + 1);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
