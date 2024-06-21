class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum%2 != 0) return false;
        return solve(nums , sum/2);
    }

    private boolean solve(int[] arr , int sum){
        int n = arr.length;
        boolean[][] dp = new boolean[n][sum + 1];

        for(int i = 0 ; i < n ; i++){
            dp[i][0] = true;
        }

        if(arr[0] <= sum){
            dp[0][arr[0]] = true;
        }

        for(int i = 1 ; i < n ; i++){
            for(int j = 1 ; j <= sum ; j++){
                boolean np = dp[i-1][j];
                boolean p = false;
                if(arr[i] <= j){
                    p = dp[i-1][j - arr[i]];
                }

                dp[i][j] = np || p;
            }
        }

        return dp[n-1][sum];
    }
}