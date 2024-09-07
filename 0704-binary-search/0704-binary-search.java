class Solution {
        public int search(int[] nums, int target) {
            int l = 0;
            int h = nums.length-1;
            while(l<=h) {
                int m = l+(h-l)/2;
                if (target == nums[m]) return m;
                if (target < nums[m]) {
                    h = m - 1;
                }
                else if (target > nums[m]) {
                    l = m + 1;
                }
            }
            return -1;
        }
}