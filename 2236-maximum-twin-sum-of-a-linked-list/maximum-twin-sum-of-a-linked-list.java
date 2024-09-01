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
    public int pairSum(ListNode head) {
      ListNode slow = head;
      ListNode fast=  head;

      while(fast!= null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;
      }

      ListNode slow2 = reverse(slow);
      slow = head;

      int max = 0;
      while(slow != null && slow2 != null){
        int sum = slow.val + slow2.val;
        max = Math.max(sum , max);

        slow = slow.next;
        slow2 = slow2.next;
      }

      return max;

    }

    private ListNode reverse(ListNode head){
      ListNode curr = head;
      ListNode prev = null;

      while(curr != null){
        ListNode next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
      }

      return prev;
    }
}