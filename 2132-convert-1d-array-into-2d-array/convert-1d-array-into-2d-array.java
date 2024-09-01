class Solution {
  public int[][] construct2DArray(int[] original, int m, int n) {
    int length = original.length;

    if (length % n != 0)
      return new int[][] {};

    if (length / n != m)
      return new int[][] {};

    int i = 0;
    int j = i + n;

    int idx = 0;
    int[][] newArr = new int[m][n];
    while (j <= length) {

      int[] temp = new int[n];
      int l = 0;
      for (int k = i; k < j; k++) {
        temp[l++] = original[k];
      }

      i = j;
      j = i + n;
      newArr[idx++] = temp;
    }

    return newArr;
  }
}