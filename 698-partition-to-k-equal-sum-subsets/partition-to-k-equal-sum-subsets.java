class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {

      int sum = Arrays.stream(nums).sum();
      if(sum%k != 0) return false;

      int target = sum/k;
      Arrays.sort(nums);
      return solve(nums.length - 1 , new int[k] , target , nums , k);        
    }

    private boolean solve(int i , int[] sums , int target , int[] nums , int k){
      if(i < 0) return true;

      for(int j = 0 ; j < sums.length ; j++){
        if(nums[i] + sums[j] > target) continue;

        sums[j] += nums[i];
        if(solve(i-1 , sums , target , nums ,k)) return true;
        sums[j] -= nums[i];

        if(sums[j] == 0) break;
      }

      return false;
    }


}