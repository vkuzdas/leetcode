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
        int res;
        int K;
        public int kthSmallest(TreeNode root, int k) {
            K = k;
            dfs(root);
            return res;
        }

        private void dfs(TreeNode root) {
            if (root.left == null && root.right == null) {
                K--;
                if(K==0) res = root.val; // TODO stop when result is found
            }
            else {
                if(root.left != null) {
                    dfs(root.left);
                }
                K--;
                if(K==0) res = root.val;
                if(root.right != null) {
                    dfs(root.right);
                }
            }
        }
}