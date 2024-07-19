class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] row = new int[m];
        int[] col = new int[n];

        for(int i = 0 ; i < m ; i++){
          int minEle = Integer.MAX_VALUE;

          for(int j = 0 ; j < n ; j++){
            minEle = Math.min(minEle , matrix[i][j]);
          }

          row[i] = minEle;
        }


        for(int j = 0 ; j < n ; j++){
          int maxEle = 0;

          for(int i = 0 ; i < m ; i++){
            maxEle = Math.max(maxEle, matrix[i][j]);
          }

          col[j] = maxEle;
        }

        List<Integer> res = new ArrayList<>();
        for(int i = 0 ; i < m ; i++){
          for(int j = 0 ; j < n ; j++){
            if(matrix[i][j] == row[i] && matrix[i][j] == col[j]){
              res.add(matrix[i][j]);
            }
          }
        }

        return res;
    }
}