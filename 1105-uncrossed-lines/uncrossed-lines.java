class Solution {
    int[][] dp;
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        dp = new int[nums1.length + 1][nums2.length + 1];
        for(int[] row : dp ) Arrays.fill(row , -1);
        return solve(0 , 0 , nums1 , nums2);
    }

    private int solve(int i , int j , int[] nums1 , int[] nums2){
      if(i >= nums1.length) return 0;
      if(j >= nums2.length) return 0;

      if(dp[i][j] != -1) return dp[i][j];

      int res = 0;

      if(nums1[i] == nums2[j]){
        res = 1 + solve(i+1 , j+1 , nums1 , nums2);
      } else{
        int skip1 = solve(i+1 , j , nums1 , nums2);
        int skip2 = solve(i , j+1 , nums1 , nums2);
        res = Math.max(skip1 , skip2);
      }

      return dp[i][j] = res;
    }
}