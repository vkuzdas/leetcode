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
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) return res;
            Queue<TreeNode> Q = new ArrayDeque<>();
            Q.add(root);
            res.add(new ArrayList<>());
            res.get(0).add(root.val);
            while (!Q.isEmpty()) {
                List<TreeNode> toQ = new ArrayList<>();
                while (!Q.isEmpty()) {
                    TreeNode node = Q.poll();
                    if (node.left != null)
                        toQ.add(node.left);
                    if (node.right != null)
                        toQ.add(node.right);
                }
                if (!toQ.isEmpty())
                    res.add(toQ.stream().map(n -> n.val).toList());
                Q.addAll(toQ);
            }
            return res;
        }
}