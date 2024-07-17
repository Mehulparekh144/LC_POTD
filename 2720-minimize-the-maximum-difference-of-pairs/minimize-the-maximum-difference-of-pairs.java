class Solution {
  public int minimizeMax(int[] nums, int p) {
    Arrays.sort(nums);
    int n = nums.length;

    int l = 0;
    int r = nums[n - 1] - nums[0];
    int ans = 0;

    while (l <= r) {
      int mid = l + (r - l) / 2;

      if (possible(mid, p, nums)) {
        ans = mid;
        r = mid - 1;
      } else {
        l = mid + 1;
      }
    }

    return ans;
  }

  private boolean possible(int ans, int p, int[] nums) {
    int n = nums.length;
    int i = 0;
    int count = 0;

    while (i < n-1) {
      if (Math.abs(nums[i] - nums[i + 1]) <= ans) {
        count++;
        i += 2;
      } else{
        i++;
      }
    }

    return count >= p;
  }
}