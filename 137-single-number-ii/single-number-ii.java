class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int k = 0 ; k < 32 ; k++){

          int zeroes = 0;
          int ones = 0;

          for(int num : nums){
            if((num & (1 << k)) == 0){
              zeroes++;
            } else{
              ones++;
            }
          }

          if(ones%3 == 1){
            res = res | (1 << k);
          }
        }

        return res;
    }
}