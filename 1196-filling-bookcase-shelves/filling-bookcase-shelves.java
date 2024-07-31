class Solution {
    int[][] dp;
    public int minHeightShelves(int[][] books, int shelfWidth) {
      dp = new int[books.length][shelfWidth + 1];
      for(int[] row : dp) Arrays.fill(row , -1);
      return solve(books.length-1 , books , shelfWidth);
    }

    private int solve(int i , int[][] books , int maxW ){
      if(i < 0){
        return 0;
      }

      if(dp[i][maxW] != -1){
        return dp[i][maxW];
      }

      int np = solve(i-1 , books , maxW) + books[i][1];
      int p = Integer.MAX_VALUE;
      int width = 0;
      int height = 0;
      for(int j = i ; j >= 0 ; j--){
        width += books[j][0];

        if(width > maxW) break;

        height=  Math.max(height , books[j][1]);
        p = Math.min(p , height + solve(j-1 , books , maxW));
        
      }

      return dp[i][maxW] = Math.min(p , np);
    }
}