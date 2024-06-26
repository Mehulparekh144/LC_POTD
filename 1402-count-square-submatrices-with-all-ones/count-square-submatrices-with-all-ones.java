class Solution {
    public int countSquares(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];

        for(int i = 0 ; i < matrix.length ; i++){
            dp[i] = matrix[i];
        }
        for(int i = 1 ; i < matrix.length ; i++){
            for(int j = 1 ; j < matrix[0].length ; j++){
                if(matrix[i][j] == 1){
                    dp[i][j] = 1 + Math.min(dp[i-1][j] , Math.min(dp[i-1][j-1] , dp[i][j-1]));
                }
            }
        }


return Arrays.stream(dp).flatMapToInt(Arrays::stream).sum();

    }
}