class Solution {
    int[][] dp;
    private int solve(int r , int k , String ring , String key){
        if(k == key.length()) return 0;
        if(dp[r][k] != -1) return dp[r][k];

        int res = Integer.MAX_VALUE;
        for(int i = 0 ; i < ring.length() ;i++){
            if(ring.charAt(i) == key.charAt(k)){
                int minSteps = Math.min(Math.abs(r-i) , ring.length() - Math.abs(r-i));
                res = Math.min(res , 1 + minSteps + solve(i , k+1 , ring,key));
            }
        }

        return dp[r][k] = res;
    }
    public int findRotateSteps(String ring, String key) {
        dp = new int[ring.length()][key.length()];
        for(int[] row : dp){
            Arrays.fill(row , -1);
        }
        return solve(0 , 0 , ring , key);
    }
}