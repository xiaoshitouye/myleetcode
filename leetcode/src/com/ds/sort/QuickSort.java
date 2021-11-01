package sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
       int[] arr = {2,6,4,6,8,0,10};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
    /*
    ������ţ�������ţ��Ż�����Ϊ˫������
     */
    private static void quickSort(int[] arr, int leftBound, int rightBound) {
        if(leftBound >= rightBound){ //�ݹ����
           return;
        }
        //����������ݣ��������ʱ�临�Ӷ�Ϊnƽ���������Խ������� ��������
        swap(arr, leftBound + (int) (Math.random() * (rightBound - leftBound + 1)), rightBound);
        //�����±�
        int mid = partion(arr, leftBound, rightBound);
        quickSort(arr, leftBound , mid - 1);
        quickSort(arr, mid + 1, rightBound);
        //midλ�ù̶������ٲ�������
    }

    private static int partion(int[] arr, int leftBound, int rightBound) {
        int pivot = arr[rightBound];
        int left = leftBound;
        int right =rightBound - 1;
        while(left <= right){
            while(left <= right && arr[left] <= pivot) left++; //�ҵ���һ����pivot������ֺ�ͣ��
            while(left <= right && arr[right] > pivot) right--;//�ҵ���һ�� <=pivot��ֵͣ��
            //���Ҷ��ҵ�һ���������������֣�ֹͣ�ƶ��±꣬��������
            if(left < right){
                swap(arr, left, right);
            }
        }
        //��left > right,����pivotλ��
        swap(arr, left, rightBound);
        return left;
    }

    private static void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }
}
