class Solution {
    public boolean stoneGame(int[] piles) {
      return dfs(0 , 0 , piles) > 0;
    }

    private int dfs(int i , int j , int[] piles){
      int n = piles.length;
      if(i >= n || j < 0) return 0;

      int takeBeg = piles[i] - dfs(i+1 , j , piles);
      int takeEnd = piles[j] - dfs(i , j-1 , piles);

      return Math.max(takeBeg,takeEnd);
    }
}