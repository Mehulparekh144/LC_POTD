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
    public ListNode swapNodes(ListNode head, int k) {
       ListNode curr = new ListNode();
       curr.next = head;
       ListNode lag = curr;
       ListNode lead = curr;

       for(int i = 0 ; i < k ; i++){
        lead = lead.next;
       } 

       ListNode first = lead;

       while(lead.next != null){
        lead = lead.next;
        lag = lag.next;
       }

        int temp = first.val;
       first.val = lag.next.val;
       lag.next.val = temp;

       return curr.next;
       

       
    }
}