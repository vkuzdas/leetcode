class Solution {
        public int search(int[] nums, int target) {
            int l = 0;
            int h = nums.length-1;

            while(l<=h) {
                int m = l+(h-l)/2;
                if (target == nums[m]) return m;

                // left sorted
                if (nums[l] <= nums[m]) {
                    if (target > nums[m] || target < nums[l])
                        l = m+1; // search right
                    else
                        h = m-1; // search left
                }
                // right is sorted
                else if (nums[m] <= nums[h]) {
                    if (target > nums[m] || target > nums[h])
                        h = m-1;
                    else 
                        l = m+1;
                }
            }
            return -1;
        }
}