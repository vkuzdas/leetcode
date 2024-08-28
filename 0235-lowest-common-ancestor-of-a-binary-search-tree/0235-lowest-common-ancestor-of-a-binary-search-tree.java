/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
        int min, max;
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            min = Math.min(p.val, q.val);
            max = Math.max(p.val, q.val);

            return DFS(root);

        }

        TreeNode DFS(TreeNode root) {
            if(min <= root.val && root.val <= max) {
                return root;
            }
            else if (min < root.val && max < root.val) {
                return DFS(root.left);
            }
            else if (max > root.val && min > root.val) {
                return DFS(root.right);
            }
            else {
                return null;
            }
        }
}