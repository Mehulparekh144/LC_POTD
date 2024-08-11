class Solution {
    public int longestIdealString(String s, int k) {
        int n = s.length();
        char[] arr = s.toCharArray();

        int[] dp = new int[26];
        int res = 0;
        int maxi = Integer.MIN_VALUE;

        for(int i = 0 ; i < n ; i++){
          
          int longest = 1;
          for(int prev = 0 ; prev < 26 ; prev++){
            if(Math.abs(arr[i] - 'a' - prev) <= k){
              longest = Math.max(longest , 1 + dp[prev]);
            }
          }

          dp[arr[i] - 'a'] = longest;
          if(longest > maxi){
            maxi = longest;
          }
        }

        return maxi;
    }
}