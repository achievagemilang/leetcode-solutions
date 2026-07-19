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
    int ans = 0;
    public int countDominantNodes(TreeNode root) {
        findMax(root);
        return ans;
    }

    public int findMax(TreeNode root){
        if (root == null) return 0;
        int leftMax = findMax(root.left);
        int rightMax = findMax(root.right);

        int currentMax = Math.max(root.val, Math.max(leftMax, rightMax));
        if(currentMax == root.val){
            ans++;
        }

        return currentMax;
        
    }
}
