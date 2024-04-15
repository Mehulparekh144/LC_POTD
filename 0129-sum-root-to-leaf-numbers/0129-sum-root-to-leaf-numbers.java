/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    private int dfs(TreeNode root , int sum) {
        if (root == null) {
            return 0 ;
        }

        sum =  sum*10 + root.val;

        if(isLeaf(root)){
            return sum;
        }

        return dfs(root.left , sum) + dfs(root.right , sum);


    }

    public int sumNumbers(TreeNode root) {
        return dfs(root , 0);
    }
}