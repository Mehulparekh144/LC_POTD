class Solution {
    private static final int MOD = (int)1e9 + 7;
    public int rangeSum(int[] nums, int n, int left, int right) {
      PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
      
      for(int i = 0 ; i < n ; i++){
        pq.offer(new int[]{nums[i] , i});
      }

      int res = 0;

      for(int i = 1 ; i <= right ; i++){
        int[] p = pq.poll();

        if(i >= left){
          res = (res + p[0])%MOD;
        }

        if(p[1] < n-1){
          p[1]++;
          p[0] += nums[p[1]];
          pq.offer(new int[]{p[0] , p[1]});
        }
      }

      return res;
    }
}