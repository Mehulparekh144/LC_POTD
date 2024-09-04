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
      if(l1 == null) return l2;
      if(l2 == null) return l1;

      if(l1.val < l2.val){
        l1.next = mergeTwo(l1.next , l2);
        return l1;
      } else{
        l2.next = mergeTwo(l1 , l2.next);
        return l2;
      }
    }
}