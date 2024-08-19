class Solution {
    public int findLongestChain(int[][] pairs) {
      Arrays.sort(pairs , (a,b) -> a[0] - b[0]);

      int n = pairs.length;
      int[] dp = new int[n];
      Arrays.fill(dp , 1);

      int maxi = 1;

      for(int i = 0 ; i < n ; i++){
        for(int prev = 0 ; prev < i ; prev++){
          if( pairs[prev][1] < pairs[i][0] && 1 + dp[prev] > dp[i] ){
            dp[i] = 1 + dp[prev];
          }

          if(dp[i] > maxi) maxi = dp[i];
        }
      }

      return maxi;

    }


}