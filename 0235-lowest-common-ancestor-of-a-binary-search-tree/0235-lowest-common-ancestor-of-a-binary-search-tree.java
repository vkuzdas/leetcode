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
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            TreeNode min = (p.val > q.val) ? q : p;
            TreeNode max = (p.val > q.val) ? p : q;
            if (min.val <= root.val && root.val <= max.val)
                return root;
            else if (root.val > max.val)
                return lowestCommonAncestor(root.left, min, max);
            else if (root.val < min.val)
                return lowestCommonAncestor(root.right, min, max);
            return root;
        }
}