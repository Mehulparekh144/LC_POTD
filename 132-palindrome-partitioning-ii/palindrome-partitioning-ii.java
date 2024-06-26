class Solution {
    int[] dp;
    public int minCut(String s) {
        dp = new int[s.length()];
        Arrays.fill(dp , -1);
        return solve(0 , s) - 1;
    }

    private int solve(int i , String s){
        if(i == s.length()) return 0;

        if(dp[i] != -1) return dp[i];

        int mini = Integer.MAX_VALUE;
        for(int j = i ; j < s.length() ; j++){
            if(isPalindrome(s , i , j)){
                int cut = 1 + solve( j + 1 , s);
                if(cut < mini) mini = cut;
            }
        }

        return dp[i] = mini;
    }

    private boolean isPalindrome(String s , int i , int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }

        return true;
    }
}