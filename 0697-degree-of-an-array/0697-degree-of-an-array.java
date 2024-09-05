class Solution {

        public int findShortestSubArray(int[] nums) {
            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
            int maxLen = 0;
            for (int i = 0; i < nums.length; i++) {
                if (!map.containsKey(nums[i])) {
                    map.put(nums[i], new ArrayList<>());
                }
                map.get(nums[i]).add(i);
                maxLen = Math.max(maxLen, map.get(nums[i]).size());
            }
            int minDiff = Integer.MAX_VALUE;
            // for each list in map, get if list has maxLen, update maxDiff
            for(ArrayList<Integer> list : map.values()) {
                if (list.size() == maxLen) {
                    minDiff = Math.min(minDiff, list.get(list.size()-1) - list.get(0)+1);
                }
            }
            return minDiff;
        }
}