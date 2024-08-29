class Solution {
        public int maxProfit(int[] A) {
            int minSoFar = Integer.MAX_VALUE;
            int profit = 0;
            for (int i = 0; i < A.length; i++) {
                minSoFar = Math.min(A[i], minSoFar);
                int newProfit = A[i] - minSoFar;
                profit = Math.max(A[i]-minSoFar, profit);
            }
            return profit;
        }
}