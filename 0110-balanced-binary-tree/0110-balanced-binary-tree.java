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
        boolean balanced = false;
        boolean balanced = true;
        public boolean isBalanced(TreeNode root) {
            getDepth(root);
            return balanced;
        }

        // return depth of given subtree
        private int getDepth(TreeNode root) {

            // if subtree has no children, D = 0
            if (root == null) {
                return 0;
            }

            // get depth of children
            int L = getDepth(root.right);
            int R = getDepth(root.left);

            // if subtrees differ by more than 1
            if(Math.abs(L-R) > 1) {
                balanced = false;
            }

            // Depth of current tree = max depth of left and right subtree
            return Math.max(L, R)+1;
        }
}