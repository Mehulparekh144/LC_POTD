/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    Map<Node,Node> map;

    public Node copyRandomList(Node head) {
      map = new HashMap<>();

      Node curr = head;
      while(curr != null){
        Node copy = new Node(curr.val);
        map.put(curr , copy);
        curr = curr.next;
      }    

      curr = head;
      while(curr != null){
        Node copy = map.get(curr);
        copy.next = map.get(curr.next);
        copy.random = map.get(curr.random);
        curr = curr.next;
      }

      return map.get(head);
    }
}