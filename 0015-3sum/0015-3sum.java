class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            HashSet<List<Integer>> result_set = new HashSet<>();
            HashMap<Integer, Integer> freq = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                if(freq.containsKey(nums[i])) {
                    freq.put(nums[i], freq.get(nums[i])+1);
                }
                else {
                    freq.put(nums[i], 1);
                }
            }

            for (int i = 0; i < nums.length; i++) {
                freq.put(nums[i], freq.get(nums[i])-1);
                for (int j = i+1; j < nums.length; j++) {
                    freq.put(nums[j], freq.get(nums[j])-1);
                    int target = -(nums[i] + nums[j]); // 0 = i+j+t    -t = i+j,    t = -(i+j)
                    if (freq.containsKey(target) && freq.get(target) > 0) {
                        Integer [] arr = new Integer[]{nums[i], nums[j], target};
                        Arrays.sort(arr);
                        List<Integer> l = Arrays.asList(arr);
                        result_set.add(l);
                    }
                    freq.put(nums[j], freq.get(nums[j])+1);
                }
                freq.put(nums[i], freq.get(nums[i])+1);
            }

            return new ArrayList<>(result_set);
        }
}