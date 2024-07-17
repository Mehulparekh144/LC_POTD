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
  public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
    Set<Integer> toDeleteSet = new HashSet<>();
    for (int val : to_delete) {
      toDeleteSet.add(val);
    }

    List<TreeNode> res = new ArrayList<>();
    root = deleteNodes(root, toDeleteSet, res);
    if (root != null) {
      res.add(root);
    }

    return res;
  }

  private TreeNode deleteNodes(TreeNode root, Set<Integer> toDeleteSet, List<TreeNode> res) {
    if (root == null) {
      return null;
    }

    root.left = deleteNodes(root.left, toDeleteSet, res);
    root.right = deleteNodes(root.right, toDeleteSet, res);

    if (toDeleteSet.contains(root.val)) {
      if (root.left != null) {
        res.add(root.left);
      }
      if (root.right != null) {
        res.add(root.right);
      }
      return null;
    }

    return root;
  }
}