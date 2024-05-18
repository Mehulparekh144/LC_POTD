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
    private int res = 0;
    private int helper(TreeNode root){        
        if(root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        res += Math.abs(left) + Math.abs(right);
        return root.val - 1 + left + right;
    }
    public int distributeCoins(TreeNode root) {
        helper(root);
        return res;
    }
}