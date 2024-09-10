class Solution {
public int coinChange(int[] coins, int amount) {
            if(coins.length == 1) {
                if (amount % coins[0] != 0) {
                    return -1;
                }
            }
            int[] dp = new int[amount+1];
            dp[0] = 0;
            for (int i = 1; i < amount+1; i++) {
                dp[i] = amount+1;
            }

            for (int i = 0; i < amount + 1; i++) {
                for (int c = 0; c < coins.length; c++) {
                    if (coins[c] > i) continue;
                    dp[i] = Math.min(dp[i], dp[i - coins[c]] + 1);
                }
            }
            return dp[amount];
        }
}