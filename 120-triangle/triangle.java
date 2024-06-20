class Solution {
    int[][] dp;
    public int minimumTotal(List<List<Integer>> triangle) {
        dp = new int[triangle.size()][triangle.getLast().size()];
        for(int[] row : dp) Arrays.fill(row , -1);
        return solve(0,0, triangle) ;
    }

    private int solve(int  i , int j , List<List<Integer>> triangle){
        if(i < 0 || j < 0 || j > triangle.get(i).size() - 1){
            return (int) Math.pow(10 , 9);
        }
        if(i == triangle.size() - 1){
            return triangle.get(i).get(j);
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }
 
        int up = triangle.get(i).get(j) + solve(i+1 , j , triangle);
        int left = triangle.get(i).get(j) + solve(i+1 , j+1 , triangle);
        return dp[i][j] = Math.min(up , left);
    }
}