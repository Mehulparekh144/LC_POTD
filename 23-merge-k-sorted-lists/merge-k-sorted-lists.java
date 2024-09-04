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
    public ListNode mergeKLists(ListNode[] lists) {
      if(lists.length == 0) return null;
      List<ListNode> list = new ArrayList<>();

      for(ListNode node : lists){
        list.add(node);
      }

      while(list.size() > 1){
        List<ListNode> merged = new ArrayList<>();

        for(int i = 0 ; i < list.size() ; i+=2){
          ListNode l1 = list.get(i);
          ListNode l2 = i+1 < list.size() ? list.get(i+1) : null;
          merged.add(mergeTwo(l1,l2));
        }

        list = merged;
      }

      return list.get(0);
      
    }

    public ListNode mergeTwo(ListNode l1, ListNode l2){
      ListNode dummy = new ListNode(0);
      ListNode curr = dummy;

      while(l1 != null && l2 != null){
        if(l1.val > l2.val){
          curr.next = new ListNode(l2.val);
          l2 = l2.next;
        } else{
          curr.next = new ListNode(l1.val);
          l1 = l1.next;
        }

        curr = curr.next;
      }

      if(l1 != null){
        curr.next = l1;
        curr = curr.next;
      }

      if(l2 != null){
        curr.next = l2;
        curr = curr.next;
      }

      return dummy.next;

    }
}