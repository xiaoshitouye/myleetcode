package sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
       int[] arr = {2,6,4,6,8,0,10};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
    /*
    经典快排，单轴快排，优化方向为双轴排序
     */
    private static void quickSort(int[] arr, int leftBound, int rightBound) {
        if(leftBound >= rightBound){ //递归出口
           return;
        }
        //随机互换数据，避免出现时间复杂度为n平方情况，如对降序数组 升序排序
        swap(arr, leftBound + (int) (Math.random() * (rightBound - leftBound + 1)), rightBound);
        //分区下标
        int mid = partion(arr, leftBound, rightBound);
        quickSort(arr, leftBound , mid - 1);
        quickSort(arr, mid + 1, rightBound);
        //mid位置固定，不再参与排序
    }

    private static int partion(int[] arr, int leftBound, int rightBound) {
        int pivot = arr[rightBound];
        int left = leftBound;
        int right =rightBound - 1;
        while(left <= right){
            while(left <= right && arr[left] <= pivot) left++; //找到第一个比pivot大的数字后停下
            while(left <= right && arr[right] > pivot) right--;//找到第一个 <=pivot的值停下
            //左右都找到一个满足条件的数字，停止移动下标，交换数据
            if(left < right){
                swap(arr, left, right);
            }
        }
        //当left > right,交换pivot位置
        swap(arr, left, rightBound);
        return left;
    }

    private static void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }
}
