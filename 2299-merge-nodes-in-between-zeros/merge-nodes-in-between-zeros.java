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
    public ListNode mergeNodes(ListNode head) {
        ListNode res = new ListNode();
        ListNode dummy = new ListNode();
        dummy.next = res;
        ListNode curr = head.next;
        int sum = 0;

        while(curr != null){
          if(curr.val == 0){
            res.next = new ListNode(sum);
            res = res.next;
            sum = 0;
          } else{
            sum += curr.val;
          }

          curr = curr.next;
        }



        return dummy.next.next;
    }
}