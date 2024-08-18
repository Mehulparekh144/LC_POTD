class Solution {
    public int jump(int[] nums) {
      int n = nums.length;
      int l = 0;
      int r = 0;

      int reachable = 0;
      int jumps = 0 ;

      while(r < n-1){
        
        for(int i = l ; i < r + 1 ; i++){
          reachable = Math.max(
            reachable,
            i + nums[i]
          );
        }

        l = r + 1;
        r = reachable;
        jumps++;

      }

      return jumps;
    }

    
}