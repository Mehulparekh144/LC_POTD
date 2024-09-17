class Solution {
    int n;
    Map<Integer,Integer> map;
    public int beautifulSubsets(int[] nums, int k) {
      n = nums.length;
      map = new HashMap<>();
      return solve(0 , nums , k);   
    }

    private int solve(int i , int[] nums , int k){
      if(i == n) return 0;

      int np = solve(i+1 , nums , k);
      int p = 0;

      if(!map.containsKey(nums[i] + k) && !map.containsKey(nums[i] - k)){
        map.put(nums[i] , map.getOrDefault(nums[i] , 0) + 1);
        p = 1 + solve(i+1 , nums , k);
        map.put(nums[i] , map.get(nums[i]) - 1);
        if(map.get(nums[i]) == 0) map.remove(nums[i]);
      }

      return np + p;
      
    }
}