class Solution {
    private static int MOD = (int)1e9 + 7;

    public int countGoodStrings(int low, int high, int zero, int one) {
      int max = high;
      int[] dp = new int[max + 1];

      dp[0] = 1;

      for(int i = 0 ; i <= max ; i++){
        if(dp[i] == 0) continue;

        if(i + zero <= max){
          dp[i+zero] = (dp[i] + dp[i + zero])%MOD;
        }

        if(i + one <= max){
          dp[i + one] = (dp[i] + dp[i + one])%MOD;
        }
      }

      int res = 0;
      for(int i = low ; i <= high ; i++){
        res = (res + dp[i])%MOD;
      }
      return res;
    }

  
}