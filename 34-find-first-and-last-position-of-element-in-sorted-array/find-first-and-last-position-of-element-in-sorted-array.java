class Solution {
  public int[] searchRange(int[] nums, int target) {
    return new int[]{first(nums , target) , last(nums,target)};
  }

  private int first(int[] nums , int target){
    int l = 0 ;
    int r = nums.length - 1;
    int first = -1;

    while(l <= r){
      int m = l + (r-l)/2;

      if(nums[m] == target){
        first = m;
        r = m - 1;
      } else if(nums[m] > target) {
        r = m - 1;
      } else{
        l = m + 1;
      }
    }

    return first;
  }

    private int last(int[] nums , int target){
    int l = 0 ;
    int r = nums.length - 1;
    int last = -1;

    while(l <= r){
      int m = l + (r-l)/2;

      if(nums[m] == target){
        last = m;
        l = m + 1;
      } else if(nums[m] > target) {
        r = m - 1;
      } else{
        l = m + 1;
      }
    }

    return last;
  }
}