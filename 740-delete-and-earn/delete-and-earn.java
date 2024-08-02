class Solution {
    int[] dp;
    public int deleteAndEarn(int[] nums) {
      Map<Integer,Integer> freq = new HashMap<>();
      dp = new int[nums.length];

      Arrays.fill(dp , -1);

      for(int num : nums){
        freq.put(num , freq.getOrDefault(num , 0) + 1);
      }

      List<Integer> arr = new ArrayList<>(freq.keySet());
      Collections.sort(arr);

      return solve(0 , arr , freq);
    }

    private int solve(int i , List<Integer> arr , Map<Integer,Integer> map){
      if(i >= arr.size()){
        return 0;
      }

      if(dp[i] != -1) return dp[i];

      int np = solve(i+1 , arr , map);
      int curr = arr.get(i);
      int p = curr * map.get(curr);

      int next = i + 1;

      if(next < arr.size() && arr.get(next) - 1 == curr ){
        p += solve(i+2 , arr , map);
      } else{
        p += solve(i+1 , arr , map);
      }

      return dp[i] = Math.max(np , p);
    }

}