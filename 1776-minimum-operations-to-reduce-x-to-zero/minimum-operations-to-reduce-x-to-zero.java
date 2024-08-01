class Solution {
  public int minOperations(int[] nums, int x) {
    int sum = 0;

    for (int num : nums) {
      sum += num;
    }

    int count = 0;
    int max = -1;
    int l = 0;
    int curr = 0;
    int target = sum - x;

    if (x > sum)
      return -1;

    for (int r = 0; r < nums.length; r++) {
      curr += nums[r];
      count++;

      while(curr > target) {
        curr -= nums[l];
        l++;
        count--;
      }

      if (curr == target) {
        max = Math.max(count, max);
      }
    }

    if (max == -1)
      return -1;

    return nums.length - max;
  }
}