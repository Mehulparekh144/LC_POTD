class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int[] prefix = new int[nums.length + 1];
        int res = 0;
        int count = 0;
        int r = 0;
        prefix[0] = 1;

        while(r < nums.length){
            if(nums[r]%2 != 0){
                count++;
            }

            if(count >= k){
                res += prefix[count - k];
            }

            prefix[count]++;
            r++;
        }

        return res;
    }
}