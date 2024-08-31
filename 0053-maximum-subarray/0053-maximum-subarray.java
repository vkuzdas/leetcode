class Solution {
public int maxSubArray(int[] nums) {
            int currSum = 0;
            int maxSoFar = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                currSum = currSum + nums[i];
                maxSoFar = Math.max(maxSoFar, currSum);
                currSum = Math.max(0, currSum); // if currsum less than zero, set to zer
            }
            return maxSoFar;
        }
}