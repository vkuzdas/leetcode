class Solution {
        public int coinChange(int[] coins, int amount) {
            if (amount==0) return 0;
            if (coins.length == 1)
                 return (amount % coins[0] == 0) ? amount/coins[0] : -1;
            int[] dp = new int[amount+1];
            dp[0] = 0;
            for (int i = 1; i < amount+1; i++) {
                dp[i] = Integer.MAX_VALUE;
            }

            for (int s = 1; s < dp.length; s++) {
                for (int c = 0; c < coins.length; c++) {
                    if (s - coins[c] >=0)
                        dp[s] = Math.min(dp[s], dp[s - coins[c]]+1);
                }
            }
            if (dp[amount] != Integer.MAX_VALUE) {
                return dp[amount];
            }
            else {
                return -1;
            }
        }
}