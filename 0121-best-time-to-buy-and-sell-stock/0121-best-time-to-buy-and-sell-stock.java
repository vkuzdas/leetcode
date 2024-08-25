class Solution {
        public int maxProfit(int[] A) {
            int min = Integer.MAX_VALUE;
            int profit = 0;
            for (int i = 0; i < A.length; i++) {
                int p = A[i];
                if (p < min) {
                    min = p;
                }
                else if (p - min > profit) {
                    profit = p - min;
                }
            }
            if (profit > 0) {
                return profit;
            }
            return 0;
        }
}