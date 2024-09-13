class Solution {
  public int[] xorQueries(int[] arr, int[][] queries) {
    int n = queries.length;
    int[] ans = new int[queries.length];

    for(int i = 0 ; i < n ; i++){
      int l = queries[i][0];
      int r = queries[i][1];
      int xor = 0;
      for(int j = l ; j <= r ; j++){
        xor ^= arr[j];
      }

      ans[i] = xor;  
    }

    return ans;
  }
}