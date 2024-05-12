class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] res = new int[n-2][n-2];
        int mx = 0;

        for(int i = 0 ; i < n-2 ; i++){
            for(int j = 0 ; j < n-2 ; j++){
                for(int m = i ; m < i+3 ; m++){
                    for(int k = j ; k < j+3 ; k++){
                        mx = Math.max(mx , grid[m][k]);
                    }
                }

                res[i][j] = mx;
                mx = 0;
            }
        }       

        return res;
    }
}