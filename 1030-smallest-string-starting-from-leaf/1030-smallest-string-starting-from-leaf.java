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
    String best;

    private int compareStrings(String s1 , String s2){
        int minLength = Math.min(s1.length() , s2.length());

        for(int i = 0 ; i < minLength ; i++){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            if(c1 > c2){
                return 1;
            } else if(c2 > c1){
                return -1;
            }
        }

        if(s1.length() > s2.length()) return 1;
        else if(s1.length() < s2.length()) return -1;
        else return 0;
    }

    private boolean isLeaf(TreeNode root){
        return root.left == null && root.right == null;
    }

    private void traverse(TreeNode root , String path){
        if(root == null) return;
        if(isLeaf(root)){
            StringBuilder sb = new StringBuilder(path);
            sb.reverse();
            if(compareStrings(best , sb.toString()) > 0){
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
        best = "zzzzzzzzzzzzzz";
        String path = String.valueOf((char)(root.val + 'a'));
        traverse(root , path);
        return best;
    }
}