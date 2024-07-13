class Solution {
    public void rotate(int[][] matrix) {
       int n = matrix.length;
       int left = 0;
       int right = n-1;

       while(left < right){

        for(int i = 0 ; i < right - left ; i++){
          int top = left;
          int bottom = right;

          int topLeft = matrix[top][left + i];

          // Top left becomes bottom left
          matrix[top][left + i] = matrix[bottom - i][left];

          //Bottom left becomes bottom right
          matrix[bottom-i][left] = matrix[bottom][right - i];

          // Bottom right becomes top right
          matrix[bottom][right - i] = matrix[top+i][right]; 
          // Top right becomes top left;
          matrix[top+i][right] = topLeft;
        }

        left++;
        right--;
       }
    }
}