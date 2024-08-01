class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
      Map<Integer,Integer> map = new HashMap<>();
      int curr = 0;
      int res = 0;
      for(int num : nums){
        curr += num;

        if(curr == goal) res++;

        if(map.containsKey(curr - goal)){
          res += map.get(curr - goal);
        }

        map.put(curr , map.getOrDefault(curr , 0 ) + 1);
      }

      return res;
    }
}