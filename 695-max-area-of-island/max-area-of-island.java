class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int area = 0;

        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == 1){
                    area = Math.max(area , dfs(i , j , grid));
                }
            }
        }

        return area;
    }

    private int dfs(int i , int j , int[][] grid){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0){
            return 0;
        }
        grid[i][j] = 0;
        int area = 0;
        area += dfs(i+1 , j , grid);
        area += dfs(i-1 , j , grid);
        area += dfs(i , j-1 , grid);
        area += dfs(i , j+1 , grid);
        return area + 1;
    }
}