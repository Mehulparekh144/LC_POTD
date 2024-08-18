class Solution {
    public int jump(int[] nums) {
      int n = nums.length;
      int[] dp = new int[n];

      for(int i = n-2 ; i >= 0 ; i--){
        int jump = (int) 1e9;
        for(int j = 1 ; j <= nums[i] ; j++){
          if(i+j < nums.length){
            jump = Math.min(jump , 1 + dp[i+j] );
          }
          
        }

        dp[i] = jump;
      }

      return dp[0];
    }

    
}