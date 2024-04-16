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
 import java.util.*;
class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newNode = new TreeNode(val);
            newNode.left = root;
            return newNode;
        }
        Queue<AbstractMap.SimpleEntry<TreeNode, Integer>> q = new LinkedList<>();
        q.add(new AbstractMap.SimpleEntry<>(root, 1));

        while (!q.isEmpty()) {
            AbstractMap.SimpleEntry<TreeNode, Integer> pair = q.poll();
            TreeNode node = pair.getKey();
            Integer level = pair.getValue();

            if (node.left != null) {
                if (level == depth - 1) {
                    TreeNode temp = node.left;
                    TreeNode newNode = new TreeNode(val);
                    node.left = newNode;
                    newNode.left = temp;
                }
                q.add(new AbstractMap.SimpleEntry(node.left, level + 1));
            } else{
                if(level == depth - 1){
                    TreeNode newNode = new TreeNode(val);              node.left = newNode;
                }
            }

            if (node.right != null) {
                if (level == depth - 1) {
                    TreeNode temp = node.right;
                    TreeNode newNode = new TreeNode(val);
                    node.right = newNode;
                    newNode.right = temp;
                }
                q.add(new AbstractMap.SimpleEntry(node.right, level + 1));
            } else{
                if(level == depth - 1){
                    TreeNode newNode = new TreeNode(val);              node.right = newNode;
                }
            }
        }

        return root;
    }
}