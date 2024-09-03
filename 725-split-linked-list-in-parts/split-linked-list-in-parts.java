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
  public ListNode[] splitListToParts(ListNode head, int k) {
    int length = 0;
    ListNode curr = head;

    while (curr != null) {
      curr = curr.next;
      length++;
    }

    int chunk = length / k;
    int remainder = length % k;

    ListNode[] res = new ListNode[k];
    curr = head;

    for (int i = 0; i < k; i++) {
      res[i] = curr;

      for (int j = 0; j < chunk - 1 + (remainder != 0 ? 1 : 0); j++) {
        if (curr == null)
          break;
        curr = curr.next;
      }

      remainder -= (remainder != 0 ? 1 : 0);
      if (curr != null) {
        ListNode temp = curr.next;
        curr.next = null;
        curr = temp;
      }
    }

    return res;

  }
}