/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
  class Pair{
    Node node;
    int level;

    public Pair(Node node , int level){
      this.node = node;
      this.level = level;
    }
  }
    public Node connect(Node root) {
      if(root == null){
        return null;
      }
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root , 0));

        while(!q.isEmpty()){

          Pair p = q.poll();
          Node node = p.node;
          int level = p.level;

          if(q.isEmpty() || q.peek().level != level){
            node.next = null;
          } else{
            node.next = q.peek().node;
          }

          if(node.left != null)
          {
            q.offer(new Pair(node.left , level + 1));
          } 

          if(node.right != null){
            q.offer(new Pair(node.right , level + 1 ));
          }
        }

        return root;
    }
}