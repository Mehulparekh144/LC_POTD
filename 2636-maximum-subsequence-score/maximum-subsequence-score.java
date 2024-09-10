class Solution {
  public long maxScore(int[] nums1, int[] nums2, int k) {
    int n = nums1.length;
    int[][] pairs = new int[n][2];
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    for(int i = 0 ; i < n ; i++){
      pairs[i] = new int[]{nums1[i] , nums2[i]};
    }

    Arrays.sort(pairs , (a,b) -> b[1] - a[1]);

    long sum = 0;
    long max = 0;

    for(int i = 0 ; i < n ; i++){
      sum += pairs[i][0];
      pq.offer(pairs[i][0]);

      if(pq.size() > k){
        sum -= pq.poll();
      }

      if(pq.size() == k){
        max = Math.max(max , sum*pairs[i][1] );
      }
    }

    return max;
  }
}