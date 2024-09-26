class Solution {
  public int[][] divideArray(int[] nums, int k) {
    int n = nums.length;
    int[][] res = new int[(n / 3)][3];
    int idx = 0;
    Arrays.sort(nums);
    for (int i = 0; i < n; i += 3) {

      if (nums[i + 2] - nums[i] > k) {
        return new int[][]{};
      }

      res[idx++] = new int[] { nums[i], nums[i + 1], nums[i + 2] };
    }

    return res;

  }
}