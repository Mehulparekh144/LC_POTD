class Solution {
    public int findTheWinner(int n, int k) {
      Deque<Integer> dq = new ArrayDeque<>();

      for(int i = 1 ; i <= n ; i++){
        dq.offerLast(i);
      }

      while(dq.size() > 1){
        for(int i = 0 ; i < k - 1 ; i++){
          int temp = dq.pollFirst();
          dq.offerLast(temp);
        }

        int remove = dq.pollFirst();
      }

      return dq.peek();
    }
}