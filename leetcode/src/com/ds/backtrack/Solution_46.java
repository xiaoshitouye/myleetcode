package backtrack;//����һ�������ظ����ֵ����� nums �������� ���п��ܵ�ȫ���� ������� ������˳�� ���ش𰸡�
//
// 
//
// ʾ�� 1�� 
//
// 
//���룺nums = [1,2,3]
//�����[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// ʾ�� 2�� 
//
// 
//���룺nums = [0,1]
//�����[[0,1],[1,0]]
// 
//
// ʾ�� 3�� 
//
// 
//���룺nums = [1]
//�����[[1]]
// 
//
// 
//
// ��ʾ�� 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums �е��������� ������ͬ 
// 
// Related Topics ���� ���� 
// ? 1534 ? 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_46 {
    public static void main(String[] args) {
        List<List<Integer>> permutes = permute(new int[]{1,2,3});
        System.out.println(Arrays.toString(new List[]{permutes}));

    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }
    private static void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
