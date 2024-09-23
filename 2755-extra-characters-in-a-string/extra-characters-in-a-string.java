class Solution {
    int[] dp;
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> set = new HashSet<>();
        dp = new int[s.length()];
        Arrays.fill(dp , -1);
        for(String d : dictionary) set.add(d);
        return solve(0 , s , set );
    }

    private int solve(int i , String s , Set<String> set){
      if(i == s.length()) return 0;

      if(dp[i] != -1) return dp[i];

      dp[i] = 1 + solve(i+1 , s , set);

      for(int j = i + 1 ; j <= s.length() ; j++){
        if(set.contains(s.substring(i , j))){
          dp[i] =  Math.min(dp[i] , solve(j, s , set));
        }
      }

      return dp[i];

    }
}