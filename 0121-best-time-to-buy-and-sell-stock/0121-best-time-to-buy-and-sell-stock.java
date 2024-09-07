class Solution {
public int maxProfit(int[] prices) {
            int minSoFar = Integer.MAX_VALUE;
            int maxDiff = 0;
            for (int i = 0; i < prices.length; i++) {
                minSoFar = Math.min(minSoFar, prices[i]);
                maxDiff = Math.max(maxDiff, prices[i] - minSoFar);
            }
            return maxDiff;
        }
}