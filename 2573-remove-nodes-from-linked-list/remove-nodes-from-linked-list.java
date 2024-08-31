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
    public ListNode removeNodes(ListNode head) {
        Stack<Integer> st = new Stack<>();
 
        ListNode curr = head;

        while(curr != null){
          while(!st.isEmpty() && st.peek() < curr.val){
            st.pop();
          }

          st.push(curr.val);
          curr = curr.next;
        }

        ListNode newNode = new ListNode(0);
        while(!st.isEmpty()){
          ListNode next = newNode.next;
          newNode.next = new ListNode(st.pop());

          newNode.next.next = next;
        }

        return newNode.next;
    }
}