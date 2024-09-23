class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> set = new HashSet<>();
        int[] dp = new int[s.length() + 1];
        for(String d : dictionary) set.add(d);


        for(int i = s.length() - 1 ; i >= 0 ; i--){
          dp[i] = 1 + dp[i+1];

          for(int j = i+1 ; j <= s.length() ; j++){
            if(set.contains(s.substring(i , j))){
              dp[i] = Math.min(dp[i] , dp[j]);
            }
          }
        }

        return dp[0];
    }

   
}