class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0;
        int r = n;

        while(l <= r){
          int x = l + (r-l)/2;
          int idx = lowerBound(nums , x);

          int count = n-idx;
          if(count == x) return x;
          else if(count > x){
            l = x + 1;
          } else{
            r = x - 1;
          }
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