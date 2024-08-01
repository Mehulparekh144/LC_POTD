class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxN = Arrays.stream(nums).max().getAsInt();
        long maxCount = 0;

        int l = 0;
        long res = 0;
        
        for(int r = 0 ; r < nums.length ; r++){
          if(nums[r] == maxN) maxCount++;

          while(maxCount > k || (l <= r && maxCount == k && nums[l] != maxN)){
            if(nums[l] == maxN) maxCount--;
            l++;
          }

          if(maxCount == k){
            res += l+1L;
          }
        }

        return res;

    }
}