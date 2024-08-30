class Solution {
        public int findShortestSubArray(int[] nums) {
            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
            HashSet<Integer> uniqNums = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                uniqNums.add(num);
                if (!map.containsKey(num)) {
                    ArrayList<Integer> l = new ArrayList<>();
                    l.add(i);
                    map.put(num, l);
                } else {
                    map.get(num).add(i);
                }
            }

            int maxDegree = Integer.MIN_VALUE;

            for(int num : uniqNums) {
                if (map.get(num).size() > maxDegree) {
                    maxDegree = map.get(num).size();
                }
            }

            int minLen = Integer.MAX_VALUE;
            for(int num : uniqNums) {
                if (map.get(num).size() == maxDegree) {
                    int diff = map.get(num).get(map.get(num).size()-1) - map.get(num).get(0) + 1;
                    minLen = Math.min(diff, minLen);
                }
            }

            return minLen;
        }
}