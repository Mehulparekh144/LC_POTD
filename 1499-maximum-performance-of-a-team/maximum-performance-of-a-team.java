class Solution {
    private static int MOD = (int) 1e9 + 7;
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
      int[][] pairs = new int[n][2];

      for(int i = 0 ; i < n ; i++){
        pairs[i] = new int[]{speed[i] , efficiency[i]};
      }

      Arrays.sort(pairs , (a,b) -> b[1] - a[1]);

      PriorityQueue<Integer> pq = new PriorityQueue<>();

      long perf = 0;
      long max = 0;

      for(int i = 0 ; i < n ; i++){
        int[] p = pairs[i];
        int sp = p[0] , eff = p[1];
        
        perf += sp;
        pq.offer(sp);

        if(pq.size() > k){
          perf -= pq.poll();
        } 

        max = Math.max(max , perf*eff);  
      }

      return (int) (max%MOD);
    }
}