package DP;//����һ���������飬���е� i ��Ԫ�ش����˵� i ��Ĺ�Ʊ�۸� ��
//
// ���һ���㷨����������������������Լ�������£�����Ծ����ܵ���ɸ���Ľ��ף��������һ֧��Ʊ��: 
//
// 
// �㲻��ͬʱ�����ʽ��ף���������ٴι���ǰ���۵�֮ǰ�Ĺ�Ʊ���� 
// ������Ʊ�����޷��ڵڶ��������Ʊ (���䶳��Ϊ 1 ��)�� 
// 
//
// ʾ��: 
//
// ����: [1,2,3,0,2]
//���: 3 
//����: ��Ӧ�Ľ���״̬Ϊ: [����, ����, �䶳��, ����, ����] 
// Related Topics ���� ��̬�滮 
// ? 912 ? 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_1143_����������� {
    public static void main(String[] args) {
        longestCommonSubsequence("abcde", "ace");
    }
    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1]; // �ȶ�dp��������ʼ������
        for (int i = 1 ; i <= text1.length() ; i++) {
            char char1 = text1.charAt(i - 1);
            for (int j = 1; j <= text2.length(); j++) {
                char char2 = text2.charAt(j - 1);
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) { // ��ʼ�г�״̬ת�Ʒ���
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        for(int i =0; i<dp.length; i++){
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[text1.length()][text2.length()];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
