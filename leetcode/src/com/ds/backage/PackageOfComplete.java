package backage;

public class PackageOfComplete {
    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagSize = 4;
//        testWeightBagProblem(weight, value, bagSize);
        testCompletePack(weight, value, bagSize);
    }

    //先遍历物品，再遍历背包
    private static void testCompletePack(int[] weight, int[] value, int bagWeight){
        int[] dp = new int[bagWeight + 1];
        for (int i = 0; i < weight.length; i++){
            for (int j = 1; j <= bagWeight; j++){
                if (j - weight[i] >= 0){
                    dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
                }
            }
        }
        for (int maxValue : dp){
            System.out.println(maxValue + "   ");
        }
    }

    //先遍历背包，再遍历物品
    private static void testCompletePackAnotherWay(int[] weight, int[] value, int bagWeight){
        int[] dp = new int[bagWeight + 1];
        for (int i = 1; i <= bagWeight; i++){
            for (int j = 0; j < weight.length; j++){
                if (i - weight[j] >= 0){
                    dp[i] = Math.max(dp[i], dp[i - weight[j]] + value[j]);
                }
            }
        }
        for (int maxValue : dp){
            System.out.println(maxValue + "   ");
        }
    }


}
