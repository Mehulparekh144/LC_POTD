class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color){
            return image;
        }
        dfs(sr , sc , image[sr][sc] , color , image);
        return image;
    }

    private void dfs(int i , int j , int src , int color , int[][] image){
        if(i < 0 || j < 0 || i >= image.length || j >= image[0].length){
            return;
        }

        if(image[i][j] != src){
            return;
        }

        image[i][j] = color;
        dfs(i+1 , j , src ,color , image);
        dfs(i-1 , j , src, color , image);
        dfs(i , j+1 , src, color , image);
        dfs(i , j-1 , src, color , image);
    }
}