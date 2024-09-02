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

    private ListNode getMiddle(ListNode head){
      if(head == null) return head;

      ListNode slow = head;
      ListNode fast = head.next;

      while(fast != null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;
      }

      return slow;
    }

    private ListNode merge(ListNode left , ListNode right){
      ListNode i = left;
      ListNode j = right;

      ListNode newNode = new ListNode();
      ListNode curr = newNode;

      while(i != null && j != null){
        if(i.val < j.val){
          curr.next = new ListNode(i.val);
          i = i.next;
        } else{
          curr.next = new ListNode(j.val);
          j = j.next;
        }
        curr = curr.next;
      }

      while(i != null){
        curr.next = new ListNode(i.val);
        i = i.next;
        curr = curr.next;
      }

      while(j != null){
        curr.next = new ListNode(j.val);
        j = j.next;
        curr = curr.next;
      }

      return newNode.next;

    }

    public ListNode sortList(ListNode head) {

      if(head == null || head.next == null) return head;
      
      ListNode middle = getMiddle(head);
      ListNode nextMiddle = middle.next;

      middle.next = null;

      ListNode left = sortList(head);
      ListNode right = sortList(nextMiddle);

      return merge(left , right);

    }
}