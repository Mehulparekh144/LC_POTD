import java.math.BigInteger;

class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<BigInteger> pq = new PriorityQueue<>((a, b) -> b.compareTo(a));


      for(String n : nums){
        pq.offer(new BigInteger(n));
      }   

      while(k > 1 && !pq.isEmpty()){
        pq.poll();
        k--;
      }

      return pq.isEmpty() ? "-1" : String.valueOf(pq.peek());
    }
}