class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int max = 0;
        int maxLen = 0;
        int currLen = 0;

        for(int num : nums){
          max = Math.max(num , max);
        }

        for(int num : nums){
          if(max == num){
            currLen++;
            maxLen = Math.max(maxLen , currLen);
          } else{
            currLen = 0;
          }
        }

        return maxLen;
    }
}