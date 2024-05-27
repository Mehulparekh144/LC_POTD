class Solution {
    public int specialArray(int[] nums) {
        int x = nums.length;
        int res = 0;
        for(int i = 0 ; i <= x ; i++){
          int count = 0;

          for(int num : nums){
            if(num >= i) count++;
          }

          if(count == i){
            res += count;
          }
          
        }

        return res == 0 ? -1 : res;
    }
}