class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];

        dp[s.length()] = 1;

        for(int i = s.length() - 1 ; i >= 0 ; i--){
            if(s.charAt(i) == '0'){
                continue;
            }

            int step1 = dp[i+1];
            int step2 = 0;
            if(i+1 < s.length() && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) < '7')))
            {
                step2 = dp[i+2];
            }

            dp[i] = step1 + step2;
        }

        return dp[0];

    }
}
