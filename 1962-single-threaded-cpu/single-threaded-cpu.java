class Solution {
  public int[] getOrder(int[][] tasks) {
    int n = tasks.length;
    int[][] pairs = new int[n][3];
    for(int i = 0 ; i < n ; i++){
      pairs[i] = new int[]{
          tasks[i][0] , tasks[i][1] , i
      };
    }

    Arrays.sort(pairs , (a,b) -> {
      if(a[0] == b[0]){
        return a[1] - b[1];
      }
      return a[0] - b[0];
    });

    PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
      if(a[1] == b[1]){
        return a[2] - b[2];
      } else{
        return a[1] - b[1];
      }
    });

    int time = 0;
    int[] res = new int[n];
    int idx = 0;
    int i = 0;

    while(idx < n || !pq.isEmpty()){
      if(pq.isEmpty() && time < pairs[idx][0]){
        time = pairs[idx][0];
      }

      while(idx < n && pairs[idx][0] <= time){
        pq.offer(new int[]{pairs[idx][0] , pairs[idx][1] , pairs[idx][2]});
        idx++;
      }

      int[] p = pq.poll();
      time += p[1];
      res[i++] = p[2];
    }
    
    return res;

  }
}