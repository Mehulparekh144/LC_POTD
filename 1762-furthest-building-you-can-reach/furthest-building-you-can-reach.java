class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
      int n = heights.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);

        for(int i = 0 ; i < n - 1 ; i++){
          int diff = heights[i+1] - heights[i];

          if(diff <= 0) continue;

          bricks -= diff;
          pq.offer(diff);

          if(bricks < 0){
            if(ladders == 0) return i;
            ladders -= 1;

            bricks += pq.poll();
          }
        }

        return n-1;
    }
}