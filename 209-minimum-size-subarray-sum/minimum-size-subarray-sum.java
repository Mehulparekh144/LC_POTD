class Solution {
    public int minSubArrayLen(int target, int[] nums) {
       int mini = Integer.MAX_VALUE;
       int sum = 0;
       int l = 0;
       int length = 0;

       for(int r = 0 ; r < nums.length ; r++){
            sum += nums[r];

            while(sum >= target){
                length = r - l + 1;
                mini = Math.min(length , mini);
                sum -= nums[l];         
                l++;
            }
       } 

       return mini == Integer.MAX_VALUE ? 0 : mini;
    }
}