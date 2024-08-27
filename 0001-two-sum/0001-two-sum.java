class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> num_idx = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int search = target - nums[i];
                if (num_idx.containsKey(search) &&  num_idx.get(search) != i) {
                    return new int[]{i, num_idx.get(search)};
                }
                num_idx.put(nums[i], i);
            }
            return new int[]{};
        }
}