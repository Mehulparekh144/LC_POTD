class Solution {
  public int minSwaps(int[] nums) {
    int l = 0;
    int n = nums.length;

    int res = Integer.MAX_VALUE;
    int count1 = 0;
    int ones = 0;

    for (int num : nums) {
      if (num == 1)
        ones++;
    }

    for (int r = 0; r < n+ones; r++) {
      count1 += nums[r % n];

      if (r - l + 1 > ones) {
        count1 -= nums[l % n];
        l++;
      }

      if (r - l + 1 == ones) {
        res = Math.min(res, ones - count1);
      }
    }

    return res;
  }
}