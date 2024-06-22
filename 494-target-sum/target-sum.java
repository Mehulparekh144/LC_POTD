class Solution {
    int[][] dp;
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        if(sum-target < 0 || (sum-target)%2 != 0){
            return 0;
        }
        dp = new int[n][(sum - target)/2 + 1];
        for(int[] row : dp) Arrays.fill(row , -1);
        return solve(n-1 , nums , (sum - target)/2);  
    }

    private int solve(int i , int[] nums , int target){
        if(i == 0){
            if(target == 0 && nums[0] == 0){
                return 2;
            } 
            if(target == 0 || nums[0] == target){
                return 1;
            }
            return 0;
        }

        if(dp[i][target] != -1) return dp[i][target];

        int np = solve(i-1 , nums , target);
        int p = 0;
        if(target >= nums[i]){
            p = solve(i-1 , nums , target - nums[i]);
        }
        return dp[i][target] = p + np;
    }
}