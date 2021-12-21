package backage;

public class Package01 {
    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagSize = 4;
//        testWeightBagProblem(weight, value, bagSize);
        testWeightBagProblemRollArray(weight, value, bagSize);
    }

    public static void testWeightBagProblem(int[] weight, int[] value, int bagSize){
        int wLen = weight.length, value0 = 0;
        //����dp���飺dp[i][j]��ʾ��������Ϊjʱ��ǰi����Ʒ�ܻ�õ�����ֵ
        int[][] dp = new int[wLen + 1][bagSize + 1];
        //��ʼ������������Ϊ0ʱ���ܻ�õļ�ֵ��Ϊ0
        for (int i = 0; i <= wLen; i++){
            dp[i][0] = value0;
        }
        //����˳���ȱ�����Ʒ���ٱ�����������
        for (int i = 1; i <= wLen; i++){
            for (int j = 1; j <= bagSize; j++){
                if (j < weight[i - 1]){
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
                }
            }
        }
        //��ӡdp����
        for (int i = 0; i <= wLen; i++){
            for (int j = 0; j <= bagSize; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public static void testWeightBagProblemRollArray(int[] weight, int[] value, int bagWeight){
        int wLen = weight.length;
        //����dp���飺dp[j]��ʾ��������Ϊjʱ���ܻ�õ�����ֵ
        int[] dp = new int[bagWeight + 1];
        //����˳���ȱ�����Ʒ���ٱ�����������
        for (int i = 0; i < wLen; i++){
            for (int j = bagWeight; j >= weight[i]; j--){
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        //��ӡdp����
        for (int j = 0; j <= bagWeight; j++){
            System.out.print(dp[j] + " ");
        }
    }


}
