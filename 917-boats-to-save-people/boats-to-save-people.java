class Solution {
    public int numRescueBoats(int[] nums, int limit) {
        int boats = 0;
        Arrays.sort(nums);
        
        int i = 0;
        int j = nums.length - 1;

        while(i <= j){

          if(nums[i] + nums[j] <= limit){
            i++;
            j--;
          } else{
            j--;
          }

          boats++;
        }

        return boats;
    }
}