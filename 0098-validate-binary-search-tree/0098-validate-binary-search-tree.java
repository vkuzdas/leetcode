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
        boolean valid = true;
        public boolean isValidBST(TreeNode root) {
            if (root == null) return true;
            dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
            return valid;
        }

        private void dfs(TreeNode root, long minVal, long maxVal) {
            if (root.val <= minVal || root.val >= maxVal) valid = false;
            if (root.left != null)
                dfs(root.left, minVal, root.val);
            if (root.right != null)
                dfs(root.right, root.val, maxVal);
        }

}