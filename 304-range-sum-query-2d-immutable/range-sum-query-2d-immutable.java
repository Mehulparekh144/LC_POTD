class NumMatrix {
    int[][] prefx;
    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // Because if the edge case is from 0,0 to 3,3 or something we would need to calculate the above -1 prefx so to avoid it we add placeholders row and column. 
        prefx = new int[m+1][n+1];

        for(int i = 0 ; i < m ; i++){
          int prefix = 0;
          for(int j = 0 ; j < n ; j++){
            prefix += matrix[i][j];
            // prefix till jth column and above row's prefix
            prefx[i+1][j+1] = prefix + prefx[i][j + 1];
          }
        }
        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
     row1++;
     col1++;
     row2++;
     col2++;

     int bottomRight = prefx[row2][col2];
     int above = prefx[row1-1][col2];

     int left = prefx[row2][col1-1];
     int topLeft = prefx[row1-1][col1-1]; 

     // 3 1 4
     // 1 2 3 
     // 4 5 6

     // Region from 1,1 to 2,2. So at 2,2 in prefx sum we calculate sum from 0,0 to 2,2. So we remove the above row and the left row. But since we removed the above and left the common top right was deleted twice to we add once.

     return bottomRight - above - left + topLeft;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */