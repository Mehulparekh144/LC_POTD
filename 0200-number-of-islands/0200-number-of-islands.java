class Solution {

    private void dfs(int i , int j , char[][] grid){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0'){
            return;
        }

        grid[i][j] = '0';
        dfs(i+1 , j , grid);
        dfs(i , j+1 , grid);
        dfs(i-1 , j , grid);
        dfs(i , j-1 , grid);
    }

    public int numIslands(char[][] grid) {
        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1'){
                    dfs(i, j, grid);
                    islands += 1;
                }
            }
        }

        return islands;
    }
}