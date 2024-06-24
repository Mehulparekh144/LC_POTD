class Solution {
    int[] dp;
    public int numDecodings(String s) {
        dp = new int[s.length()];
        Arrays.fill(dp , -1);
        return solve(0 , s);
    }

    private int solve(int i , String s){
        
        if(i == s.length()){
            return 1;
        }

        if(s.charAt(i) == '0') return 0;

        if(dp[i] != -1) return dp[i];

        int step1 = solve(i+1 , s);
        int step2 = 0;

        if(i+1 < s.length() && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) < '7'))){
            step2 = solve(i+2 , s);
        }

        return dp[i] = step1 + step2;
    }
}
