class Solution {
    public int splitArray(int[] nums, int k) {
        int l = Arrays.stream(nums).max().getAsInt();
        int r = Arrays.stream(nums).sum();
        int ans = 0;

        while(l <= r){
          int m = l + (r-l)/2;

          if(canMakeSubarray(m , k , nums)){
            ans = m;
            r = m - 1;
          } else{
            l = m + 1;
          }
        }

        return ans;
    }

    private boolean canMakeSubarray(int m , int k , int[] nums){
      int count = 1;
      int sum = 0;
      for(int i = 0 ; i < nums.length ; i++){
        sum += nums[i];

        if(sum > m){
          sum = nums[i];
          count++;
        }
      }

      return count <= k;
    }


}