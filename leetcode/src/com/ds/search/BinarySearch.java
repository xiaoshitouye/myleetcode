package search;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {

	public static void main(String[] args) {


	}
	public static int binarySearch(int[] arr, int left, int right, int findVal) {
		System.out.println("二分查找被调用~");
		// 当 left > right 时，说明递归整个数组，但是没有找到
		if (left > right) {
			return -1;
		}
		int mid = (left + right) / 2;
		int midVal = arr[mid];

		if (findVal > midVal) { // 向 右递归
			return binarySearch(arr, mid + 1, right, findVal);
		} else if (findVal < midVal) { // 向左递归
			return binarySearch(arr, left, mid - 1, findVal);
		} else {

			return mid;
		}
	}
}
