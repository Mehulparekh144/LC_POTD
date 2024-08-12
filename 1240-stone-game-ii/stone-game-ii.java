class Solution {
    Integer[][] dp;
    public int stoneGameII(int[] piles) {
        int totalStones = 0;
        for(int pile : piles) totalStones += pile;

        dp = new Integer[piles.length + 1][piles.length + 1];

        return (totalStones + solve(0 , piles , 1))/2;
    }

    private int solve(int i , int[] piles , int M){
      if(i == piles.length) return 0;

      if(dp[i][M] != null) return dp[i][M];

      int total = Integer.MIN_VALUE;
      int stones = 0;
      for(int X = 1 ; X <= 2*M ; X++){
        if(i + X > piles.length) continue;

        stones += piles[i + X - 1];
        total = Math.max(total , stones - solve(i + X , piles , Math.max(M , X)));
      }

      return dp[i][M] = total;
    }
}