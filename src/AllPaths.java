import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

public class AllPaths {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.allPathsSourceTarget(new int[][]{{1,2},{3},{3},{}}));
        System.out.println(s.allPathsSourceTarget(new int[][]{{4,3,1},{3,2,4},{3},{4},{}}));
    }

    private static class Solution {
        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            List<List<Integer>> res = new ArrayList<>();

            int target = graph.length - 1;
            dfs(List.of(0), target, res, graph); // current node is at the end of arr, res gets appended when target is reached

            return res;
        }

        private void dfs(List<Integer> path, int target, List<List<Integer>> res, int[][] graph) {
            int curr = path.get(path.size()-1);
            if (curr == target) {
                res.add(path);
                return;
            }

            int[] nbrs = graph[curr];
            for(int nbr : nbrs) {
                List<Integer> newPath = new ArrayList<>(path);
                newPath.add(nbr);
                dfs(newPath, target, res, graph);
            }
        }
    }

}
