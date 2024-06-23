class Solution {
    private int lcs(String s , String t){
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];

        for(int i = 1 ; i <= m ; i++){
            for(int j = 1 ; j <= n ; j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else{
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }

        return dp[m][n];
    }
    public int minDistance(String word1, String word2) {
        int lcs = lcs(word1 , word2);
        int delete = word1.length() - lcs;
        int insert = word2.length() - lcs;
        return delete + insert;
    }
}