class Solution {
        public int maxSubArray(int[] nums) {
            if (nums.length == 1) return nums[0];
            int maxSoFar = Integer.MIN_VALUE;
            int currSum = 0;
            for (int i = 0; i < nums.length; i++) {
                currSum = currSum + nums[i];
                maxSoFar = Math.max(maxSoFar, currSum);
                if (currSum < 0) {
                    currSum = 0;
                }
            }
            return maxSoFar;
        }
}