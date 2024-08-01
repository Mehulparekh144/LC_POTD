class Solution {
  public int numSubarraysWithSum(int[] nums, int goal) {
    // Finding <= goal
    return slidingWindow(nums, goal) - slidingWindow(nums, goal - 1);
  }

  private int slidingWindow(int[] nums, int goal) {
    if (goal < 0)
      return 0;
    int l = 0, curr = 0, res = 0;

    for (int r = 0; r < nums.length; r++) {
      curr += nums[r];

      while (curr > goal) {
        curr -= nums[l++];
      }

      res += (r - l + 1);
    }

    return res;

  }
}