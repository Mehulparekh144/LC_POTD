class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
      
      int n = nums.length;
      long[] delta = new long[n];

      for(int i = 0 ; i < n ; i++){
        delta[i] = (nums[i]^k) - nums[i];
      }

      Arrays.sort(delta);
      long res = 0;
      for(int num : nums){
        res += num;
      }

      for(int i = nums.length - 1 ; i > 0 ; i-=2){
        long buffer = delta[i] + delta[i - 1];
        if(buffer <= 0) break;
        res += buffer;
      }

      return res;
    }
}