/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode curr = head;
        ListNode left = new ListNode();
        ListNode right = new ListNode();

        ListNode l = left;
        ListNode r = right;

        while(curr != null){
          if(curr.val < x){
            l.next = new ListNode(curr.val);
            l = l.next;            
          } else{
            r.next = new ListNode(curr.val);
            r = r.next;
          }

          curr = curr.next;
        }

        l.next = right.next;
        return left.next;
    }
}