class Solution {
    int[][] dp;
    public int minFallingPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] prev = new int[n];

        for(int j = 0 ; j < n ; j++){
            prev[j] = grid[m-1][j];
        }

        for(int i = m - 2 ; i >= 0 ; i--){
            int[] curr = new int[n];
            for(int j = n - 1 ; j >= 0 ; j--){
                int down = grid[i][j] + prev[j];
                int leftDiag = Integer.MAX_VALUE;
                int rightDiag = Integer.MAX_VALUE;

                if(j > 0){
                    leftDiag = grid[i][j] + prev[j-1];
                } 

                if(j < n-1){
                    rightDiag = grid[i][j] + prev[j+1];
                }

                curr[j] = Math.min(down , Math.min(leftDiag , rightDiag));
            }

            prev = curr;

        }

        int mini = Integer.MAX_VALUE;
        for(int j = 0 ; j < n ; j++){
            mini = Math.min(mini , prev[j]);
        }
        return mini;
    }

   
}