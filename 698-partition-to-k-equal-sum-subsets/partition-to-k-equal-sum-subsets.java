class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {

      int sum = Arrays.stream(nums).sum();
      if(sum%k != 0) return false;

      // We try to find the target and sort the array and traverse in reverse to handle large numbers pehle.
      int target = sum/k;
      Arrays.sort(nums);
      return solve(nums.length - 1 , new int[k] , target , nums , k);        
    }

    private boolean solve(int i , int[] sums , int target , int[] nums , int k){
      if(i < 0) return true;

      // the sums array represents the subsets and here if the sum exceeds we dnt consider
      // We backtrack and after backtracking if the sum becomes zero we break. When we backtrack and remove a number from a subset, if that subset becomes empty (sum becomes 0), it means we're back to the starting point for that subset. If we continue to the next iteration of the loop, we'd be trying to add the current number to another empty subset. This would lead to exploring the same combinations we've already explored or will explore in future recursive calls.


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