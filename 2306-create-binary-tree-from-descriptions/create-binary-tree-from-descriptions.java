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
  public TreeNode createBinaryTree(int[][] descriptions) {
    boolean[] isChild = new boolean[100001];
    TreeNode[] nodes = new TreeNode[100001];

    for(int[] d : descriptions){
      int node = d[0];
      int child = d[1];
      int isLeft = d[2];

      if(nodes[node] == null){
        nodes[node] = new TreeNode(node);
      }

      if(nodes[child] == null){
        nodes[child] = new TreeNode(child);
      }

      if(isLeft == 1){
        nodes[node].left = nodes[child];
      } else{
        nodes[node].right = nodes[child];
      }

      isChild[child] = true;
    }


    for(int[] d : descriptions){
      if(!isChild[d[0]]){
        return nodes[d[0]];
      }
    }

    return null;

  }
}