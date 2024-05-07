/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    private ListNode reverseLL(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public ListNode doubleIt(ListNode head) {
        int carry = 0;
        int r = 0;
        ListNode curr = reverseLL(head);
        ListNode dummy = new ListNode();
        dummy.next = curr;

        while (curr != null) {
            r = curr.val * 2;
            int value = r % 10 + carry;
            carry = r / 10;
            curr.val = value;
            curr = curr.next;
        }

        ListNode newNode = dummy;
        if(carry != 0){
        while(dummy.next != null){
            dummy = dummy.next;
        }
        dummy.next = new ListNode(carry);
        }

        return reverseLL(newNode.next);
    }
}