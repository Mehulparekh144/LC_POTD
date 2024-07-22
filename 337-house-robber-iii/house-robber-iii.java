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
    Map<TreeNode,Integer> map;
    public int rob(TreeNode root) {
      map = new HashMap<>();
      return solve(root);  
    }

    private int solve(TreeNode root){
      if(root == null){
        return 0;
      }

      if(map.containsKey(root)){
        return map.get(root);
      }

      int p = root.val;
      if(root.left != null){
        p += solve(root.left.left) + solve(root.left.right);
      }

      if(root.right != null){
        p += solve(root.right.left) + solve(root.right.right);
      }

      int np = solve(root.left) + solve(root.right);

      int res = Math.max(p , np);
      map.put(root , res);
      return res;
    }
}