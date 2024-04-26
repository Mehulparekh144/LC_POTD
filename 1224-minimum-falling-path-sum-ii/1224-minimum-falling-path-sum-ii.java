class Solution {
    int[][] dp;
    private int solve(int i , int j , int[][] grid ){
        if(i == 0){
            return grid[i][j];
        }

        if(dp[i][j] != -1) return dp[i][j];

        int mini = Integer.MAX_VALUE;
        for(int k = 0 ; k < grid[0].length ; k++){
            if(k != j){
                int sum = grid[i][j] + solve(i-1 , k , grid);
                if(sum < mini) mini = sum;
            }
        }

        return dp[i][j] = mini;

    }
    public int minFallingPathSum(int[][] grid) {
        dp = new int[grid.length][grid[0].length];
        for(int[] row : dp) Arrays.fill(row , -1);
        int mini = Integer.MAX_VALUE;
        for(int j = 0 ; j < grid[0].length ; j++){
            mini = Math.min(mini , solve(grid.length - 1 , j , grid ));
        }

        return mini;
    }
}