class Solution {
  public int[] longestObstacleCourseAtEachPosition(int[] nums) {
    int n = nums.length;
    int[] arr = new int[n];
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if(res.isEmpty() || res.getLast() <= nums[i]){
        res.addLast(nums[i]);
        arr[i] = res.size();
      } else{
        int l = 0;
        int r = res.size() - 1;

        while(l < r){
          int m = l + (r-l)/2;

          if(res.get(m) > nums[i]){
            r = m;
          } else{
            l = m + 1;
          }
        }

        res.set(r , nums[i]);
        arr[i] = r + 1 ;
      }


    }

    return arr;

  }
}