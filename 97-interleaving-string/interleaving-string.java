class Solution {
    int m ;
    int n ;
    int l ;
    int[][][] dp;

    public boolean isInterleave(String s1, String s2, String s3) {
      m = s1.length();
      n = s2.length();
      l = s3.length();

      dp = new int[m+1][n+1][l+1];
      for(int[][] mat : dp){
        for(int[] row : mat){
          Arrays.fill(row , -1);
        }
      }

      return dfs(0 , 0 , 0 , s1 , s2 ,s3);    
    }

    private boolean dfs(int i , int j , int k , String s1 , String s2 , String s3){

      if(i == m && j == n && k == l) return true;

      if(k >= l) return false;

      if(dp[i][j][k] != -1) return dp[i][j][k] == 1;


      boolean res = false;

      if(i < m && s1.charAt(i) == s3.charAt(k)){
        res = dfs(i+1 , j , k+1 , s1 , s2 ,s3);
      }

      if(res) return true;

      if(j < n && s2.charAt(j) == s3.charAt(k)){
        res = dfs(i , j+1 , k+1 , s1 , s2 , s3);
      }

      dp[i][j][k] = res == true ? 1 : 0;

      return res;
    }
}