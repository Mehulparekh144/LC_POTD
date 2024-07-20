class Solution {
  public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
    int m = rowSum.length;
    int n = colSum.length;
    int[][] mat = new int[m][n];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (rowSum[i] < colSum[j]) {
          mat[i][j] = rowSum[i];
        } else if (rowSum[i] > colSum[j]) {
          mat[i][j] = colSum[j];
        } else {
          mat[i][j] = colSum[j];
        }

        rowSum[i] -= mat[i][j];
        colSum[j] -= mat[i][j];
      }
    }

    return mat;
  }
}