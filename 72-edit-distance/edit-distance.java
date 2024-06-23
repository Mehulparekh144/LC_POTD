class Solution {
    int[][] dp;
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        dp = new int[m][n];
        for(int[] row : dp) Arrays.fill(row , -1);
        return solve(m-1 , n-1 , word1 , word2);
    }

    private int solve(int i , int j , String s , String t){
        // j is left to be traversed. Whatever is left will be inserted
        if(i < 0){
            return j + 1;
        } 
        // if i is left and j is exhausted. That means all characters left in s will be deleted.
        if(j < 0){
            return i + 1;
        }

        if(dp[i][j] != -1) return dp[i][j];

        if(s.charAt(i) == t.charAt(j)){
            return dp[i][j] = solve(i-1 , j-1 , s , t);
        }
        else{
            int insert = 1 + solve(i , j - 1 , s , t);
            int replace = 1 + solve(i-1 , j-1 , s , t);
            int delete = 1 + solve(i-1 , j , s , t);
            return dp[i][j] = Math.min(insert , Math.min(replace , delete));
        }
    }
}