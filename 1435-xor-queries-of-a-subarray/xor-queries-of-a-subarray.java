class Solution {
  public int[] xorQueries(int[] arr, int[][] queries) {
    int n = queries.length;
    int[] ans = new int[n];
    int[] pref = new int[arr.length];
    pref[0] = arr[0];

    for(int i = 1 ; i < arr.length ; i++){
      pref[i] = pref[i-1]^arr[i];
    }

    for(int i = 0 ; i < n ; i++){
      int l = queries[i][0];
      int r = queries[i][1];

      if(l == 0){
        ans[i] = pref[r];
      } else{
        // Xoring with the previous element that has been xorred in prefix array will be nullifed 
        ans[i] = pref[r] ^ pref[l-1];
      }
    }

    return ans;
  }
}