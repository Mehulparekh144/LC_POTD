class Solution {
    int[] dp;
    private int solve(int i, String s) {
        if (i == s.length())
            return 0;
        if(dp[i] != -1) return dp[i];
        int mini = Integer.MAX_VALUE;
        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(i , j , s)) {
                int cuts = 1 + solve(j + 1, s);
                if (cuts < mini)
                    mini = cuts;
            }

        }

        return dp[i] = mini;
    }

    private boolean isPalindrome(int i , int j ,String s) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public int minCut(String s) {
        dp = new int[s.length()];
        Arrays.fill(dp , -1);
        return solve(0, s) - 1;
    }

}