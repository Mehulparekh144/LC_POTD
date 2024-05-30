class Solution {
    public int countTriplets(int[] arr) {
      int res = 0;
      int prefix = 0;
      Map<Integer,Integer> count = new HashMap<>();
      count.put(0 , 1);
      Map<Integer,Integer> total = new HashMap<>();

      for(int i = 0 ; i < arr.length ; i++){
        prefix ^= arr[i];
        int c = count.getOrDefault(prefix , 0);
        int t = total.getOrDefault(prefix , 0);
        res += c * i-t;
        count.put(prefix , c + 1);
        total.put(prefix , t + i + 1);
      }

      return res;

    }
}