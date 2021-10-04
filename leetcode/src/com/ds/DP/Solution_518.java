package DP;

class Solution_518 {
    public static void main(String[] args) {
        change(5, new int[] {1, 2, 5});
    }

    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
                System.out.println("dp[" +i +"]:"+ dp[i]);
            }
            System.out.println("------------");
        }
        return dp[amount];
    }
}