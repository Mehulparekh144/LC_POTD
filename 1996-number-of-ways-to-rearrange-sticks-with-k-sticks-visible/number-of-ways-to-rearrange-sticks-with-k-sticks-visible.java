/**
 * Pick largest candle 3 so now other sub problem will be (n-1)* dfs why n-1
 * because since 3 is largest all others will be visible
 */
class Solution {
  private final static int MOD = (int) 1e9 + 7;
  public int rearrangeSticks(int n, int k) {
    long[] prev = new long[k + 1];
    long[] curr = new long[k+1];
    prev[1] = 1;

    for(int i = 2 ; i <= n ; i++){
      for(int j = 1 ; j <= k ; j++){
        curr[j] = prev[j-1] + (i-1)*prev[j];
        curr[j] %= MOD;
      }

      prev = curr.clone();
    }

    return (int) prev[k];
  }
}