class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] leftSum = new int[n];
        int[] rightSum = new int[n];

        leftSum[0] = 0;

        for(int i = 1 ; i < n ; i++){
          leftSum[i] = leftSum[i-1] + nums[i-1];
        }

        rightSum[n-1] = 0;
        for(int i = n-2 ; i >= 0 ; i--){
          rightSum[i] = rightSum[i + 1] + nums[i+1];
        }

        int[] res = new int[n];

        for(int i = 0 ; i < n ; i++){
          res[i] = i*nums[i] - leftSum[i] + rightSum[i] - nums[i]*(n-i-1);
        }

        return res;
    }

      // for ith element in array
        // Break it down to 3 parts.
        // LEFT : 
        // abs(nums[i] - nums[0]) + abs(nums[i] - nums[1]) + abs(nums[i] - nums[2]) ... + abs(nums[i] - nums[i-1])

        // MIDDLE :
        // abs(nums[i] - nums[i])

        // RIGHT : 
        // abs(nums[i] - nums[i+1]) + abs(nums[i] - nums[i+2]) ... + abs(nums[i] - nums[n-1])

        // Simplify all of them, since in left all numbers till i-1 are smaller than nums[i]. nums[i]*i - (nums[0] + ... + nums[i-1]);

        // Middle will be 0 so doesn't matter
        // Right again nums[i+1] onwards number will be greater so (nums[i+1] .. + nums[n-1] )  - nums[i]*(n- i - 1) 
}