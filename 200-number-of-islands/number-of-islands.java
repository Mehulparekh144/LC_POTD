class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        boolean[][] vis = new boolean[grid.length][grid[0].length];


        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == '1' && !vis[i][j]){
                    dfs(i , j , grid , vis);
                    count++;
                }
            }
        }

        return count;
    }


    private void dfs(int i , int j , char[][] grid , boolean[][] vis){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0' || vis[i][j]){
            return;
        }

        vis[i][j] = true;

        dfs(i+1 , j , grid, vis);
        dfs(i-1 , j , grid, vis);
        dfs(i , j+1 , grid, vis);
        dfs(i , j-1 , grid, vis);
    }
}