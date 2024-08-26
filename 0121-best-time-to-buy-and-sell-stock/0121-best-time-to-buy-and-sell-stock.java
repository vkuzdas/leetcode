class Solution {
        public int maxProfit(int[] prices) {
            int min = Integer.MAX_VALUE;
            int profit = 0;
            for (int i = 0; i < prices.length; i++) {
                int price = prices[i];
                
                // disjoint conditions since buy & sell on same day does not make sense
                if (min > price) {
                    // found better min
                    min = price;
                }
                else if (profit < price - min) {
                    // found better profit
                    profit = price - min;
                }
            }
            return profit;
        }
}