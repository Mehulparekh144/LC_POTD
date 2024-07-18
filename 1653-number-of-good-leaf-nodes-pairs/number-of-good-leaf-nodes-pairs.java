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
    public int countPairs(TreeNode root, int distance) {
        int[] goodPairs = new int[1];

        dfs(root , distance , goodPairs);

        return goodPairs[0];
    }

    private List<Integer> dfs(TreeNode root , int distance , int[] goodPairs){
      if(root == null){
        return new ArrayList<>();
      }

      if(root.left == null && root.right == null){
        return new ArrayList<>(List.of(1));
      }

      List<Integer> leftList = dfs(root.left , distance , goodPairs);
      List<Integer> rightList = dfs(root.right , distance , goodPairs);

      for(int l : leftList){
        if(l >= distance){
          continue;
        }

        for(int r : rightList){
          if(l + r <= distance){
            goodPairs[0]++;
          }
        }
      }

      List<Integer> temp = new ArrayList<>();
      for(int l : leftList){
        temp.add(1 + l);
      }

      for(int r : rightList){
        temp.add(1 + r);
      }

      return temp;
    }
}