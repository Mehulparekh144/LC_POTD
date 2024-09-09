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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] mat = new int[m][n];
        for(int[] row : mat) Arrays.fill(row , -1);

        int l = 0;
        int t = 0;
        int b = m-1;
        int r = n-1;

        ListNode curr = head;
        while(curr != null){
          
          for(int i = l ; i <= r ; i++){
            if(curr != null){
              mat[t][i] = curr.val;
              curr = curr.next;
            }else{
              break;
            }
          }
          t++;

          for(int i = t ; i <= b ; i++){
            if(curr != null){
              mat[i][r] = curr.val;
              curr = curr.next;
            } else{
              break;
            }
          }
          r--;

          for(int i = r ; i >= l ; i--){
            if(curr != null){
              mat[b][i] = curr.val;
              curr = curr.next;
            } else{
              break;
            }
          }
          b--;

          for(int i = b ; i >= t ; i--){
            if(curr != null){
              mat[i][l] = curr.val;
              curr = curr.next;
            } else{
              break;
            }
          }
          l++;

        }

        return mat;

    }
}