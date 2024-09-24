class Solution {
  public int[] getSumAbsoluteDifferences(int[] nums) {
    int n = nums.length;
    int[] prefix = new int[n];

    prefix[0] = nums[0];

    for(int i = 1 ; i < n ; i++ ){
      prefix[i] = prefix[i-1] + nums[i];
    }
    // In prefixSum , sum for left of i will be prefix[i] - arr[i];
    // Sum for right of i will be prefix[n-1] - prefix[i]

    int[] res = new int[n];

    for (int i = 0; i < n; i++) {
      int leftSum = prefix[i] - nums[i];
      int rightSum = prefix[n-1] - prefix[i];
      res[i] = i * nums[i] - leftSum + rightSum - nums[i] * (n - i - 1);
    }

    return res;
  }

  // for ith element in array
  // Break it down to 3 parts.
  // LEFT :
  // abs(nums[i] - nums[0]) + abs(nums[i] - nums[1]) + abs(nums[i] - nums[2]) ...
  // + abs(nums[i] - nums[i-1])

  // MIDDLE :
  // abs(nums[i] - nums[i])

  // RIGHT :
  // abs(nums[i] - nums[i+1]) + abs(nums[i] - nums[i+2]) ... + abs(nums[i] -
  // nums[n-1])

  // Simplify all of them, since in left all numbers till i-1 are smaller than
  // nums[i]. nums[i]*i - (nums[0] + ... + nums[i-1]);

  // Middle will be 0 so doesn't matter
  // Right again nums[i+1] onwards number will be greater so (nums[i+1] .. +
  // nums[n-1] ) - nums[i]*(n- i - 1)
}