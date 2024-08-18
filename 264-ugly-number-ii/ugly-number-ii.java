class Solution {
  public int nthUglyNumber(int n) {
    Set<Long> s = new HashSet<>();
    PriorityQueue<Long> pq = new PriorityQueue<>();

    int[] factors = {2,3,5};
    pq.offer(1L);

    for(int i = 0 ; i < n ; i++){
      long num = pq.poll();

      if(i == n-1) return (int) num;

      for(int f : factors){
        if(!s.contains(f*num)){
          s.add(num*f);
          pq.offer(num*f);
        }
      }

    }

    return -1;

  }
}