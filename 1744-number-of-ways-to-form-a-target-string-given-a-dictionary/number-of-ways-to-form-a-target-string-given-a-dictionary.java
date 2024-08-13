class Solution {
  private final int MOD = (int) 1e9 + 7;
  long[][] dp;

  public int numWays(String[] words, String target) {
    int[][] freq = new int[26][words[0].length()];
    dp = new long[target.length() + 1][words[0].length() + 1];

    for(String word : words){
      for(int i = 0 ; i < word.length() ; i++){
        freq[word.charAt(i) - 'a'][i] += 1;
      }
    }

    for(long[] row : dp) Arrays.fill(row , -1);

    return (int) solve(0 , 0 , words , target , freq);
  }

  private long solve(int i , int k , String[]words , String target , int[][] freq) {

    if(i == target.length()) return 1;

    if(k >= words[0].length()) return 0;

    if(dp[i][k] != -1) return dp[i][k];

    long ways = solve(i , k+1 , words , target , freq);

    char targetChar = target.charAt(i);

    if(freq[targetChar - 'a'][k] > 0){
      ways += freq[targetChar - 'a'][k] * solve(i+1 , k+1 , words , target , freq);
      ways %= MOD;
    }

    return dp[i][k] = ways;
  }

}