class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
    int n = wage.length;
    int[][] pairs = new int[n][2];

    for(int i = 0 ; i < n ; i++){
      pairs[i] = new int[]{wage[i] , quality[i]};
    }

    Arrays.sort(pairs , Comparator.comparingDouble(a -> (double) a[0] / a[1]));

    PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) ->  b-a);

    int sum = 0;
    double min = Integer.MAX_VALUE;
    for(int[] p : pairs){
      sum += p[1];
      pq.offer(p[1]);

      if(pq.size() > k){
        sum -= pq.poll();
      }

      if(pq.size() == k){
        min = Math.min(
          min,
          sum * ( (double) p[0] / p[1] )
        );
      }
    }

    return min;
    }
}