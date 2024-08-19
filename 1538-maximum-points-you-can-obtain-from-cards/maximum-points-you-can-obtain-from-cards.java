class Solution {
    public int maxScore(int[] nums, int k) {
      int n = nums.length;

      if(k == n){
        return Arrays.stream(nums).sum();
      }

      int lSum = 0;
      int rSum = 0;

      for(int i = 0 ; i < k ; i++){
        lSum += nums[i];
      }

      int l = k-1;
      int r = n-1;

      int maxSum = lSum + rSum;

      while(l >= 0){
        lSum -= nums[l];
        rSum += nums[r];

        maxSum = Math.max(maxSum , lSum + rSum);
        l--;
        r--;
      }

      return maxSum;
    }
}