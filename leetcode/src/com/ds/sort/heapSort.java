package sort;

import java.util.Arrays;

public class heapSort {
    public static void main(String[] args) {
        int[] arr = {2,5,3,8,6,9,7,10,0};
          heapsort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void heapsort(int[] arr) {
        if(arr == null || arr.length < 2) return;
        int size = arr.length;
        for(int i = 0; i < size; i++){
            heapInsert(arr, i);
        }
        swap(arr, 0, --size);
        while(size > 0){
            heapify(arr, 0, size);
            swap(arr, 0, --size);
        }
    }

    private static void heapify(int[] arr, int index, int size) {
        int left = 2 * index + 1;
        while(left < size){//自上至下，找到第一个比左右节点都大的节点后停止循环
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1: left;
            largest = arr[largest] > arr[index] ? largest : index;
            if(largest == index){//直到找到某个位置比左右节点大
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = 2 * index + 1;

        }
    }

    private static void heapInsert(int[] arr, int index) {
        while(arr[index] >  arr[(index - 1) / 2]){//自下至上，当遇到第一个比自己大的父节点停止循环
           swap(arr, index, (index - 1) / 2);
           index = (index - 1) /2;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;

    }
}
