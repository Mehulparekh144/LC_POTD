class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int res = Integer.MAX_VALUE;

        while (l <= r) {
            int m = l + (r - l) / 2;

            if(nums[m] == nums[l] && nums[l] == nums[r]){               res = Math.min(res, nums[l]);
                l++;
                r--;
            }
            else if (nums[m] >= nums[l]) {
                    res = Math.min(res, nums[l]);
                    l = m + 1;
            } else if(nums[m] <= nums[l]) {
                res = Math.min(res, nums[m]);
                r = m - 1;
            }
        }

        return res;
    }
}