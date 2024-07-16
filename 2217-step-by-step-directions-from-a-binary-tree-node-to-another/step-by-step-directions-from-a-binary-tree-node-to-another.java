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
  public String getDirections(TreeNode root, int startValue, int destValue) {
    // Find the LCA Crucial Point
    TreeNode curr = findLCA(root , startValue, destValue);
    // Find path from LCA -> Start
    StringBuilder start = new StringBuilder();
    // Find path from LCA ->> Dest
    StringBuilder end = new StringBuilder();
    findPath(curr, startValue, start);
    findPath(curr, destValue, end);

    StringBuilder pathUp = new StringBuilder();
    for (int i = 0; i < start.length(); i++) {
      pathUp.append('U');
    }

    return pathUp.toString() + end.toString();
  }

  private TreeNode findLCA(TreeNode root , int p , int q){
    if(root == null || root.val == p || root.val == q){
      return root;
    }

    TreeNode left = findLCA(root.left , p , q);
    TreeNode right = findLCA(root.right , p , q);

    if(left != null && right != null){
      return root;
    } else if(left == null){
      return right;
    } else{
      return left;
    }
  }


  private boolean findPath(TreeNode node, int val, StringBuilder path) {
    if (node == null) {
      return false;
    }
    if (node.val == val) {
      return true;
    }

    path.append("L");
    if(findPath(node.left , val , path)){
      return true;
    }
    path.deleteCharAt(path.length() - 1);

    path.append("R");
    if(findPath(node.right , val , path)){
      return true;
    }
    path.deleteCharAt(path.length() - 1);

    return false;
  }
}