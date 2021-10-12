package DP;//����һ��רҵ��С͵���ƻ�͵���ؽֵķ��ݣ�ÿ�䷿�ڶ�����һ�����ֽ�����ط����еķ��ݶ� Χ��һȦ ������ζ�ŵ�һ�����ݺ����һ�������ǽ����ŵġ�ͬʱ�����ڵ�
//����װ���໥��ͨ�ķ���ϵͳ������������ڵķ�����ͬһ���ϱ�С͵���룬ϵͳ���Զ����� �� 
//
// ����һ������ÿ�����ݴ�Ž��ķǸ��������飬������ �ڲ���������װ�õ������ �������ܹ�͵�Ե�����߽� 
//
// 
//
// ʾ�� 1�� 
//
// 
//���룺nums = [2,3,2]
//�����3
//���ͣ��㲻����͵�� 1 �ŷ��ݣ���� = 2����Ȼ��͵�� 3 �ŷ��ݣ���� = 2��, ��Ϊ���������ڵġ�
// 
//
// ʾ�� 2�� 
//
// 
//���룺nums = [1,2,3,1]
//�����4
//���ͣ��������͵�� 1 �ŷ��ݣ���� = 1����Ȼ��͵�� 3 �ŷ��ݣ���� = 3����
//?    ͵�Ե�����߽�� = 1 + 3 = 4 �� 
//
// ʾ�� 3�� 
//
// 
//���룺nums = [0]
//�����0
// 
//
// 
//
// ��ʾ�� 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 1000 
// 
// Related Topics ���� ��̬�滮 
// ? 793 ? 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_213_��ҽ���2 {
    public static void main(String[] args) {
//        System.out.println(rob(new int[]{2,7,9,3,1}));
        System.out.println(rob(new int[]{1,2,1,1}));
    }
    public static  int rob(int[] nums) {
        if(nums == null || nums.length == 0) return  0;
        int len = nums.length;
        if(len == 1) {
            return nums[0];
        }else if(len == 2){
            return  Math.max(nums[0], nums[1]);
        }
        return  Math.max(robRange(nums, 0, len - 2), robRange(nums, 1, len - 1));
    }
    private  static  int robRange(int[] nums, int start, int end){
        int len = end - start + 1;
        if(len == 1) return nums[0];
        int[] dp = new int[len];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i < len; i++){
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return  dp[len - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
