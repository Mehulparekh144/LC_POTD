class Solution {
    public int rob(int[] nums) {
        int prev2 = 0;
        int prev = nums[nums.length - 1];
        int curr = 0;
        for(int i = nums.length - 2 ; i >= 0 ; i--){
            int p = nums[i] + prev2;
            int np = prev;
            curr = Math.max(np, p);
            prev2 = prev;
            prev = curr;
        }

        return prev;
    }
}