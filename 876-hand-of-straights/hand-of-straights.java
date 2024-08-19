class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
      int n = hand.length;
      if(n%groupSize != 0) return false;

      Map<Integer,Integer> map = new HashMap<>();

      for(int num : hand){
        map.put(num , map.getOrDefault(num , 0) + 1);
      }  

      PriorityQueue<Integer> pq = new PriorityQueue<>();
      for(int k : map.keySet()){
        pq.offer(k);
      }

      while(!pq.isEmpty()){
        int current = pq.peek();

        for(int j = current ; j < current + groupSize ; j++){
          if(!map.containsKey(j)){
            return false;
          }

          map.put(j , map.get(j) - 1 );

          if(map.get(j) == 0){
            if(j != pq.peek()) return false;
            pq.remove(j);
          }

        }
      }

      return true;
    }
}