class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        for(int x = 0; x <= n ; x++){
          // Find idx of number just greater than equal to x
          int idx = lowerBound(nums , x);
          if(idx == -1) continue;
          int count = n - idx;
          if(count == x) return x;
        }

        return -1;
    }

    private int lowerBound(int[] nums , int x){
      int l = 0;
      int r = nums.length - 1;
      int idx = -1;
      while(l <= r){
        int mid = (l+r)/2;

        if(nums[mid] >= x){
          idx = mid;
          r = mid - 1;
        } else{
          l = mid + 1;
        }
      }

      return idx;
    }
}