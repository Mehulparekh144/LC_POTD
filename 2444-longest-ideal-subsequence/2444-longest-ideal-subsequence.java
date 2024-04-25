class Solution {
    public int longestIdealString(String s, int k) {
        int n = s.length();
        int[] dp = new int[27];
        char[] arr = s.toCharArray();
        int res = Integer.MIN_VALUE;
        for(int i = n-1 ; i >= 0 ; i--){
            char ch = arr[i];
            int idx = ch - 'a';
            int maxi = Integer.MIN_VALUE;
            int l = Math.max(idx - k , 0);
            int r = Math.min(idx + k , 26);

            for(int j = l ; j <= r ; j++){
                maxi = Math.max(maxi , dp[j]);
            }
            dp[idx] = maxi + 1;
            if(dp[idx] > res){
                res = dp[idx];
            }
            }
            return res;
        }
}