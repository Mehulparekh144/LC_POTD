class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        int[] orig = queries.clone();
        Arrays.sort(queries);
        Arrays.sort(intervals , (a,b) -> a[0] - b[0]);
        int[] freq = new int[queries[queries.length-1] + 1];

        int j = 0;

        for(int query : queries){

          while(j < intervals.length && intervals[j][0] <= query){
            int st = intervals[j][0];
            int end = intervals[j][1];
            int size = end - st + 1;
            pq.offer(new int[]{end , size});
            j++;
          }

          while(!pq.isEmpty() && pq.peek()[0] < query){
            pq.poll();
          } 

          if(pq.isEmpty()){
            freq[query] = -1;
          } else{
            freq[query] = pq.peek()[1];
          }
        }

        int[] res = new int[queries.length];

        for(int i = 0 ; i < queries.length ; i++){
          res[i] = freq[orig[i]];
        }

        return res;

    }
}