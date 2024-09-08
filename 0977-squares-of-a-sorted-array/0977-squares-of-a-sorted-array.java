class Solution {
        public int[] sortedSquares(int[] nums) {
            if(nums.length == 1)
                return new int[]{nums[0]*nums[0]};


            // find split and square all
            int split = -1;
            for (int i = 0; i < nums.length; i++) {
                if (split == -1 && nums[i] >= 0) {
                    split = i;
                }
                nums[i] = nums[i]*nums[i];
            }

            if(split == -1) {
                split = nums.length-1;
            }

            int i = 0;
            int l = split-1;
            int r = split;
            int[] res = new int[nums.length];
            while (i < nums.length && l >= 0 && r <= nums.length-1) {
                if (nums[l] <= nums[r]) {
                    res[i] = nums[l];
                    l--;
                }
                else {
                    res[i] = nums[r];
                    r++;
                }
                i++;
            }
            while (r < nums.length) {
                res[i] = nums[r];
                i++;
                r++;
            }
            while (l >= 0) {
                res[i] = nums[l];
                i++;
                l--;
            }

            return res;

        }
}