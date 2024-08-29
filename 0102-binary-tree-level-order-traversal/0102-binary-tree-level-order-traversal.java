import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
        

        class Pair {
            TreeNode t;
            int d;

            public Pair(TreeNode t, int d) {
                this.t = t;
                this.d = d;
            }
        }


        public List<List<Integer>> levelOrder(TreeNode root) {
            HashMap<Integer, List<Integer>> map = new HashMap<>();
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }

            Queue<Pair> Q = new ArrayDeque<>();
            Q.add(new Pair(root, 0));
            map.put(0, List.of(root.val));
//            result.add(List.of(root.val));

            while (!Q.isEmpty()) {
                Pair top = Q.poll();
                if (top.t.left == null && top.t.right == null) {
                    continue;
                }
                // ADD BOTH
                else if (top.t.left != null && top.t.right != null) {
                    if (!map.containsKey(top.d+1)) {
                        map.put(top.d+1, new ArrayList<>());
                        map.get(top.d+1).add(top.t.left.val);
                        map.get(top.d+1).add(top.t.right.val);
                    }
                    else {
                        map.get(top.d+1).add(top.t.left.val);
                        map.get(top.d+1).add(top.t.right.val);
                    }
                    Q.add(new Pair(top.t.left, top.d+1));
                    Q.add(new Pair(top.t.right, top.d+1));
                }
                // ADD RIGHT
                else if (top.t.left == null) {
                    if (!map.containsKey(top.d+1)) {
                        map.put(top.d+1, new ArrayList<>());
                        map.get(top.d+1).add(top.t.right.val);
                    }
                    else {
                        map.get(top.d+1).add(top.t.right.val);
                    }
                    Q.add(new Pair(top.t.right, top.d+1));
                }
                // ADD LEFT
                else if (top.t.right == null) {
                    if (!map.containsKey(top.d+1)) {
                        map.put(top.d+1, new ArrayList<>());
                        map.get(top.d+1).add(top.t.left.val);
                    }
                    else {
                        map.get(top.d+1).add(top.t.left.val);
                    }
                    Q.add(new Pair(top.t.left, top.d+1));
                }
            }
            for (int i = 0; i < map.size(); i++) {
                result.add(map.get(i));
            }
            return result;
        }
}