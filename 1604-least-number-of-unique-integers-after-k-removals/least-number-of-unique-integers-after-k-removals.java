class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
      PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);

      Map<Integer,Integer> map = new HashMap<>();
      for(int a : arr){
        map.put(a , map.getOrDefault(a , 0) + 1);
      }

      for(Map.Entry<Integer,Integer> e : map.entrySet()){
        pq.offer(new int[]{e.getKey() , e.getValue()});
      }

      while(k > 0){
        if(pq.peek()[1] > k){
          pq.peek()[1] -= k;
          break;
        }

        k -= pq.peek()[1];
        pq.poll();
      }

      return pq.size();
    
    }
}