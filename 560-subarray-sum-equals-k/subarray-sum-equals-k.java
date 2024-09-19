class Solution {
    public int subarraySum(int[] nums, int k) {
      int count = 0;
      int pfx = 0;
      Map<Integer,Integer> map = new HashMap<>();

      map.put(0 , 1); // Prefix sum 0 

      for(int n : nums){
        pfx += n;

        if(map.containsKey(pfx - k)){
          count += map.get(pfx - k);
        }

        map.put(pfx , map.getOrDefault(pfx , 0) + 1);
      }

      return count;   
    }
}