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
        boolean balanced = true;
        public boolean isBalanced(TreeNode root) {
            getDepth(root);
            return balanced;
        }

        private int getDepth(TreeNode root) {

            if(root == null) return 0;

            int L = getDepth(root.left);
            int R = getDepth(root.right);
            if(Math.abs(R-L) > 1)
                balanced = false;
            return Math.max(R,L) + 1;
        }
}