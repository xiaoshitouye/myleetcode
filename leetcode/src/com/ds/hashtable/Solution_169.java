//����һ����СΪ n �����飬�ҵ����еĶ���Ԫ�ء�����Ԫ����ָ�������г��ִ��� ���� ? n/2 ? ��Ԫ�ء�
//
// ����Լ��������Ƿǿյģ����Ҹ������������Ǵ��ڶ���Ԫ�ء�
//
//
//
// ʾ�� 1��
//
//
//���룺[3,2,3]
//�����3
//
// ʾ�� 2��
//
//
//���룺[2,2,1,1,1,2,2]
//�����2
//
//
//
//
// ���ף�
//
//
// �������ʱ�临�Ӷ�Ϊ O(n)���ռ临�Ӷ�Ϊ O(1) ���㷨��������⡣
//
// Related Topics ���� ��ϣ�� ���� ���� ����
// ? 1129 ? 0
package hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_169 {
    public static void main(String[] args) {
        int permutes = majorityElement(new int[]{1,2,3});
        System.out.println(permutes);

    }
    private static Map<Integer, Integer> countNums(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 1);
            } else {
                counts.put(num, counts.get(num) + 1);
            }
        }
        return counts;
    }

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> counts = countNums(nums);

        Map.Entry<Integer, Integer> majorityEntry = null;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                majorityEntry = entry;
            }
        }

        return  majorityEntry.getKey();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
