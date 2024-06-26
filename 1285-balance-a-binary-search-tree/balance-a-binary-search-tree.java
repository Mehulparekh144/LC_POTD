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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        inorder(root , traversal);

        return convertToBST(0 , traversal.size() - 1 , traversal);
    }


    private TreeNode convertToBST(int l , int r , List<Integer> traversal){
        if(l > r){
            return null;
        }

        int mid = l + (r-l)/ 2;
        
        TreeNode node = new TreeNode(traversal.get(mid));
        node.left = convertToBST(l , mid-1 , traversal);
        node.right = convertToBST(mid + 1 , r , traversal);
        return node;

    }

    private void inorder(TreeNode root , List<Integer> traversal){
        if(root == null){
            return;
        }

        inorder(root.left , traversal);
        traversal.add(root.val);
        inorder(root.right , traversal);
    }
}