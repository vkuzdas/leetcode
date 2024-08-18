import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

public class Subsets {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.subsets(new int[]{1,2,3}));
    }

    private static class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();

            ArrayList<Integer> subset = new ArrayList<>();
            ArrayList<Integer> notUsed = new ArrayList<>();
            for(int num : nums) notUsed.add(num);
            res.add(subset);
            dfs(subset, notUsed, res);

            return res;
        }

        // add first num from nums to ints
        // this is new subset
        // add the subset to result
        // enter new iteration
        // if subset has full length (nums are empty), stop recursion
        private void dfs(ArrayList<Integer> used, ArrayList<Integer> notUsed, List<List<Integer>> res) {
            for (int i = 0; i < notUsed.size(); i++) {
                int num = notUsed.get(i);

                if (!used.isEmpty() && num < used.get(used.size()-1)) {
                    continue;
                }

                ArrayList<Integer> subset = new ArrayList<>(used);
                subset.add(num);
                res.add(subset);

                ArrayList<Integer> newNums = new ArrayList<>(notUsed);
                newNums.remove(i);

                if (notUsed.size() != 1) {
                    dfs(subset, newNums, res);
                }
            }
        }

    }
}
