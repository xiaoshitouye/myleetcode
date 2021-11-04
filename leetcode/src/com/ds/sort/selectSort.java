package sort;

import java.util.Arrays;

public class selectSort {
    public static void main(String[] args) {
        int[] arr = {2,5,3,8,6,9,7,10,0};
        selectsort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void selectsort(int[] arr) {
        int len = arr.length;
        for(int i = 0; i < len; i++){
            int minindex = i;
            for(int j = i + 1; j < len; j++){
              minindex = arr[minindex] < arr[j] ? minindex : j;
            }
            swap(arr, minindex, i);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
