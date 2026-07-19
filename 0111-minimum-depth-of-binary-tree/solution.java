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
    public int minDepth(TreeNode root) {
        return minDepthHelper(root, 0);
    }

    public int minDepthHelper(TreeNode root, int h){
        if(root == null) return h;
        if(root.right == null && root.left == null) return h + 1;

        if(root.left == null) return minDepthHelper(root.right, h + 1);
        if(root.right == null) return minDepthHelper(root.left, h + 1);

        int left = minDepthHelper(root.left, h + 1);
        int right = minDepthHelper(root.right, h + 1);

        return Math.min(left, right);
    }
}
