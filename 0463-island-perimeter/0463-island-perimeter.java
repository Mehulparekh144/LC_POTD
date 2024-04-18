class Solution {
    private boolean isSurrounded(int i , int j , int[][] grid){
        if (i < 0 || i >= grid.length || j >= grid[0].length || j < 0){
            return true;
        }
        if(grid[i][j] == 0){
            return true;
        }
        return false;
    }

    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == 1){
                    if(isSurrounded(i+1 , j ,grid)){
                        perimeter += 1;
                    }

                    if(isSurrounded(i-1 , j ,grid)){
                        perimeter += 1;
                    }

                    if(isSurrounded(i , j-1 ,grid)){
                        perimeter += 1;
                    }

                    if(isSurrounded(i , j+1 , grid)){
                        perimeter += 1;
                    }
                }
            }
        }

        return perimeter;
        
    }
}