package search;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {

	public static void main(String[] args) {


	}
	public static int binarySearch(int[] arr, int left, int right, int findVal) {
		System.out.println("���ֲ��ұ�����~");
		// �� left > right ʱ��˵���ݹ��������飬����û���ҵ�
		if (left > right) {
			return -1;
		}
		int mid = (left + right) / 2;
		int midVal = arr[mid];

		if (findVal > midVal) { // �� �ҵݹ�
			return binarySearch(arr, mid + 1, right, findVal);
		} else if (findVal < midVal) { // ����ݹ�
			return binarySearch(arr, left, mid - 1, findVal);
		} else {

			return mid;
		}
	}
}
