class Solution {
  private static final int MOD = (int)1e9 + 7;
    int[][][] dp;
    public int countOfPairs(int[] nums) {
      dp = new int[nums.length][51][51];
      for(int[][] mat : dp){
        for(int[] row : mat){
          Arrays.fill(row , -1);
        }
      }
       return solve(0 , nums , 0 , 50); 
    }

    private int solve(int i , int[] nums , int prev , int prev2){
      if(i >= nums.length) return 1;

      if(dp[i][prev][prev2] != -1) return dp[i][prev][prev2];

      int ans = 0;

      for(int j = 0 ; j <= nums[i] ; j++){
        int x = j;
        int y = nums[i] - j;

        if(x >= prev && y <= prev2){
          ans = (ans + solve(i+1 , nums , x , y))%MOD;
        }
      }

      return dp[i][prev][prev2] = ans;
    }
}