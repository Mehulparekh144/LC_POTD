class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();

        for(int i = 0 ; i <= n ; i++){
          adj.add(new ArrayList<>());
        }

        for(int[] time : times){
          adj.get(time[0]).add(new int[]{time[1] , time[2]});
        }

       PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
       pq.offer(new int[]{k , 0});

       int[] timesArr = new int[n+1];
       Arrays.fill(timesArr , (int) 1e9);
       timesArr[k] = 0;


       while(!pq.isEmpty()){
        int[] pair = pq.poll();
        int node = pair[0];
        int time = pair[1];

        for(int[] childPair : adj.get(node)){
          int child = childPair[0];
          int t = childPair[1];

          if(timesArr[child] > t + time){
            timesArr[child] = t + time;
            pq.offer(new int[]{child , timesArr[child]});
          }
        }

       }

       System.out.println(Arrays.toString(timesArr));

       int max = 0;
       for(int i = 1 ; i <= n ; i++){
        max = Math.max(max , timesArr[i]);
       }

       return max == 1e9 ? -1 : max;


    }
}