class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] prev = new int[n];
        int[] curr = new int[n];

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(obstacleGrid[i][j] == 1){
                    curr[j] = 0;
                    continue;
                }
                if(i == 0 && j == 0){
                    curr[0] = 1;
                    continue;
                }

                int up = 0;
                int left = 0;
                if(i > 0){
                    up = prev[j];
                }

                if(j > 0){
                    left = curr[j-1];
                }

                curr[j] = up + left;
            }

            prev = curr;
        }
        return curr[n-1];
    }

   
}