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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
      List<Integer> r1 =  dfs(root1, new ArrayList<>()); 
      List<Integer> r2   = dfs(root2 , new ArrayList<>()); 

      return r1.equals(r2);
    }

    private List<Integer> dfs(TreeNode root , List<Integer> res){
      if(root == null){
        return res;
      }

      if(root.left == null && root.right == null){
        res.add(root.val);
      }

      dfs(root.left , res);
      dfs(root.right , res);
      return res;
    }


}