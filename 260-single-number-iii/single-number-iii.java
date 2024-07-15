class Solution {
    public int[] singleNumber(int[] nums) {
        // XOR All elements
        int xor = 0;
        for(int num : nums){
          xor ^= num;
        }

        // Check which bit is set for xor;
        int setBit = 0;
        for(int i = 0 ; i < 32 ; i++){
          if((xor & (1 << i)) != 0){
            setBit = i;
            break;
          }
        }

        int groupA = 0;
        int groupB = 0;

        for(int num : nums){
          if((num & (1 << setBit) )== 0){
            groupA ^= num;
          } else{
            groupB ^= num;
          }
        }

        return new int[]{groupA , groupB};
    }
}