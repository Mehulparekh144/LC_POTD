class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);

        int l = 0;
        int r = nums[nums.length - 1];

        while(l < r){
          int m = l + (r-l)/2;

          int c = getCount(nums , m);

          if(c >= k){
            r = m;
          } else{
            l = m + 1;
          }
        }

        return r;
    }

    private int getCount(int[] nums , int diff){
      int l = 0;
      int count = 0;

      for(int r = 1 ; r < nums.length ; r++){
        while(Math.abs(nums[r] - nums[l]) > diff){
          l++;
        }

        count += (r - l);
      }

      return count;
    }
}