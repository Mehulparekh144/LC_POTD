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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newL = new ListNode(0);
        ListNode dummy = newL;

        ListNode curr1 = list1;
        ListNode curr2 = list2;

        while(curr1 != null && curr2 != null){
          if(curr1.val > curr2.val){
            newL.next = new ListNode(curr2.val);
            curr2 = curr2.next;
          } else{
            newL.next = new ListNode(curr1.val);
            curr1 = curr1.next;
          }
          newL = newL.next;
        }

        while(curr1 != null){
          newL.next = new ListNode(curr1.val);
          curr1 = curr1.next;
          newL = newL.next;
        }

        while(curr2 != null){
          newL.next = new ListNode(curr2.val);
          curr2 = curr2.next;
          newL = newL.next;
        }

        return dummy.next;
    }
}