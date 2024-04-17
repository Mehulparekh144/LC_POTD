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
    List<String> res;
    String best;
    private boolean isLeaf(TreeNode root){
        return root.left == null && root.right == null;
    }

    private void traverse(TreeNode root , String path){
        if(root == null) return;
        if(isLeaf(root)){
            StringBuilder sb = new StringBuilder(path);
            sb.reverse();
            if(best.compareTo(sb.toString()) > 0){
                best = sb.toString();
            }
        }
        if(root.left != null){
            traverse(root.left , path + (char)(root.left.val + 'a'));
        }
        if(root.right != null){
            traverse(root.right , path + (char)(root.right.val + 'a'));
        }
    }

    public String smallestFromLeaf(TreeNode root) {
        res = new ArrayList<>();
        best = "zzzzzzzzzzzzzzzz";
        String path = String.valueOf((char)(root.val + 'a'));
        traverse(root , path);
        return best;
    }
}