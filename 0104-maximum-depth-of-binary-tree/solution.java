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
    public int maxDepth(TreeNode root) {
        return maxDepthHelper(root, 0);
    }

    public int maxDepthHelper(TreeNode root, int max){
        if (root == null) return max;
        max++;

        int left = maxDepthHelper(root.left, max);
        int right = maxDepthHelper(root.right, max);

        return Math.max(left, right);
    }
}

