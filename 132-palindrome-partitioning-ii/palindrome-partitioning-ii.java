class Solution {

    public int minCut(String s) {
        int[] dp = new int[s.length() + 1];


        for(int i = s.length() - 1 ; i >= 0 ; i--){
        int mini = Integer.MAX_VALUE;
            for(int j = i ; j < s.length() ; j++ ){
                if(isPalindrome(s , i , j)){
                    int cut = 1 + dp[j+1];
                    if(mini > cut) mini = cut;
                }
            }

            dp[i] = mini;

        }

        return dp[0] - 1;
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