class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            HashSet<List<Integer>> res = new HashSet<>();
            HashMap<Integer, Integer> indices = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                indices.put(nums[i], i);
            }

            for (int i = 0; i < nums.length; i++) {
                for (int j = i+1; j < nums.length; j++) {
                    int search = -(nums[i] + nums[j]); // i+j+k=0,  i+j=-k
                    if(indices.containsKey(search) && indices.get(search) != i && indices.get(search) != j) {
                        ArrayList<Integer> l = new ArrayList<>(3);
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(search);
                        Collections.sort(l);
                        res.add(l);
                    }
                }
            }

            return new ArrayList<>(res);
        }
}