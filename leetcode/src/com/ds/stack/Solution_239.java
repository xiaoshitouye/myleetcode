package stack;//����һ���������� nums����һ����СΪ k �Ļ������ڴ������������ƶ�����������Ҳࡣ��ֻ���Կ����ڻ��������ڵ� k �����֡���������ÿ��ֻ�����ƶ�һλ
//�� 
//
// ���ػ��������е����ֵ�� 
//
// 
//
// ʾ�� 1�� 
//
// 
//���룺nums = [1,3,-1,-3,5,3,6,7], k = 3
//�����[3,3,5,5,6,7]
//���ͣ�
//�������ڵ�λ��                ���ֵ
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// ʾ�� 2�� 
//
// 
//���룺nums = [1], k = 1
//�����[1]
// 
//
// ʾ�� 3�� 
//
// 
//���룺nums = [1,-1], k = 1
//�����[1,-1]
// 
//
// ʾ�� 4�� 
//
// 
//���룺nums = [9,11], k = 2
//�����[11]
// 
//
// ʾ�� 5�� 
//
// 
//���룺nums = [4,-2], k = 2
//�����[4] 
//
// 
//
// ��ʾ�� 
//
// 
// 1 <= nums.length <= 105 
// -104 <= nums[i] <= 104 
// 1 <= k <= nums.length 
// 
// Related Topics ���� ���� �������� �������� �ѣ����ȶ��У� 
// ? 1170 ? 0


import java.util.Arrays;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_239 {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
        System.out.println(Integer.MAX_VALUE % 10);
        System.out.println(Integer.MIN_VALUE % 10);
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length < 2) return nums;
        int[] res = new int[nums.length - k + 1];
        LinkedList<Integer> deque = new LinkedList<Integer>();
        for(int i = 0; i < nums.length; i++){
            while(!deque.isEmpty() && nums[i] > nums[deque.getLast()]){//�����ݼ�ջ
                deque.removeLast();
            }
            deque.addLast(i);
            if(deque.getFirst() <= i - k){//�������ͷ��λ�ò��ڴ��ڷ�Χ�ڣ�ɾ��
                deque.removeFirst();
            }
            if(i + 1 >= k){//���ڴ�С����kֵ
               res[i - k + 1] = nums[deque.getFirst()];
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
