class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for(int i = 0 ; i < n ; i++){
          if(res.isEmpty() || res.getLast() < nums[i] ){
            res.addLast(nums[i]);
          } else{
            int l = 0;
            int r = res.size() - 1;
            
            while(l < r){
              int m = l + (r-l)/2;

              if(res.get(m) >= nums[i]){
                r = m;
              } else{
                l = m + 1;
              }
            }

            res.set(r , nums[i]);
          }
        }

        return res.size();
    }
}