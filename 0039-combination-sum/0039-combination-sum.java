class Solution {
        HashSet<List<Integer>> res = new HashSet<>();
        int[] cans;
        int t;
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            cans = candidates;
            t = target;
            dfs(new ArrayList<Integer>());

            return new ArrayList<>(res);
        }

        // can be sped up by not recalculating sum
        private void dfs(ArrayList<Integer> used) {
            int sum = 0;
            for(int u : used) {
                sum = sum + u;
            }
            if (sum > t) return;
            if (sum == t) {
                res.add(used);
                return;
            }

            for(int c : cans) {
                ArrayList<Integer> used2 = new ArrayList<>(used);
                used2.add(c);
                Collections.sort(used2);
                if (!res.contains(used2))
                    dfs(used2);
            }
        }
}