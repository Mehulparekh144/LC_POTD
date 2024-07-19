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
    private boolean isLeafNode(TreeNode root){
      if(root == null) return false;
      return root.left == null && root.right == null;
    }
    public boolean evaluateTree(TreeNode root) {
        if(root == null){
          return true;
        }

        if(isLeafNode(root)){
          return root.val == 1;
        }

        if(root.val == 2){
          return evaluateTree(root.left) || evaluateTree(root.right);
        } else{
          return evaluateTree(root.left) && evaluateTree(root.right);
        }
    }
}