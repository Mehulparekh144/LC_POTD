class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        String t = reverse(s);

        int[][] dp = new int[n+1][n+1];

        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= n ;j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else{
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }

        return dp[n][n];
    }

    private String reverse(String s){
        StringBuilder sb = new StringBuilder();
        for(int i = s.length() - 1 ; i >= 0 ; i--){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public int minInsertions(String s) {
        int lcs = longestPalindromeSubseq(s);
        return s.length() - lcs;
    }
}