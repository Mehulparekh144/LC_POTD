class Solution {
    public int findMin(int[] nums) {
      int n = nums.length;
        int l = 0;
        int r = n - 1;
        int res = Integer.MAX_VALUE;

        while(l <= r){
          int m = l + ((r-l) >> 1);

          if(nums[m] >= nums[l]){
            res = Math.min(res , nums[l]);
            l = m +1;
          } else{
            res = Math.min(res , nums[m]);
            r = m - 1;
          }
        }

        return res;
    }
}