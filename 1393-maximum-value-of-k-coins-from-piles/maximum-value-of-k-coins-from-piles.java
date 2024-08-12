class Solution {
  int[][] dp;
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        dp = new int[piles.size()][k+1];
        for(int[] row : dp){
          Arrays.fill(row , -1);
        }
        return solve(0 , piles , k);
    }

    private int solve(int i , List<List<Integer>> piles , int k){
      if(i >= piles.size() || k <= 0){
        return 0;
      }

      if(dp[i][k] != -1) return dp[i][k];

      int np = solve(i+1 , piles , k);
      int p = 0;

      int total = 0;
      List<Integer> pile = piles.get(i);

      for(int j = 1 ; j <= Math.min(k, pile.size()) ; j++){
        total += pile.get(j - 1);
        p = Math.max(p ,total + solve(i+1 , piles , k - j));
      }

      return dp[i][k] = Math.max(p , np);

    }
}