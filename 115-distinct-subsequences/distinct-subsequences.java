class Solution {
    int[][] dp;
    public int numDistinct(String s, String t) {
        dp = new int[s.length() + 1][t.length() + 1];
        for(int[] row : dp) Arrays.fill(row , -1);
        return solve(s.length() , t.length() , s , t);
    }

    private int solve(int i , int j , String s , String t){
        if(j == 0){
            return 1;
        }

        if(i == 0){
            return 0;
        }

        if(dp[i][j] != -1) return dp[i][j];

        if(s.charAt(i-1) == t.charAt(j-1)){
            return dp[i][j] = solve(i-1 , j-1 , s , t) + solve(i-1 , j ,s ,t);
        } 

        return dp[i][j] = solve(i-1 , j , s , t);
    }


}