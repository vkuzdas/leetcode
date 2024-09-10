class Solution {
        public int[] productExceptSelf(int[] nums) {
            int [] out = new int[nums.length];
            int t = 1;
            int zeroCount = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    t = t * nums[i];
                } else {
                    zeroCount++;
                }
            }

            if (zeroCount > 1) {
                return out; // all zeroes
            }

            if (zeroCount == 0) {
                for (int i = 0; i < out.length; i++) {
                    out[i] = t / nums[i];
                }
                return out;
            }
                
            if (zeroCount == 1) {
                for (int i = 0; i < out.length; i++) {
                    if (nums[i] != 0)
                        continue;
                    else if (nums[i] == 0)
                        out[i] = t;
                }
            }

            return out;
        }
}