class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.getLast().size()];

        for(int j = 0 ; j < triangle.getLast().size() ; j++){
            dp[triangle.size() - 1][j] = triangle.get(triangle.size() - 1).get(j);
        }

        for(int i = triangle.size() - 2 ; i >= 0 ; i--){
            for(int j = i ; j >= 0 ; j--){
                int up = triangle.get(i).get(j) + dp[i+1][j];
                int diagonal = triangle.get(i).get(j) + dp[i+1][j+1];
                dp[i][j] = Math.min(up , diagonal);
            }
        }

        return dp[0][0];

    }

}