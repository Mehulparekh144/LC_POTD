class Solution {
  public int firstMissingPositive(int[] nums) {
        // Observations : 
        // (1 , n) -> n = nums.length 
        // Check if 1 is there or not, if its not there return 1 then and there
        // Don't consider <=0 or >n , if encountered convert to 1 as we have already checked for 1 before, it won't cause an issue

        int n = nums.length;
        boolean isOne = false;
        for(int i = 0 ; i < n ; i++){
          if(nums[i] == 1 ){
            isOne = true;
          }

          if(nums[i] <= 0 || nums[i] > n){
            nums[i] = 1;
          }
        }

        if(!isOne) return 1;


        for(int i = 0 ; i < n  ; i++){
          int num = Math.abs(nums[i]);
          int idx = num - 1;

          if(nums[idx] < 0) continue;
          // We mark it as -1 because it means that it has been visited
          nums[idx] *= -1;
        }

        for(int i = 0 ; i < n ; i++){
          if(nums[i] > 0){
            // If its not visited or not minus one that means we weren't able to visit this number or this index since we get index as num - 1 if num is not there we won't be able to reach this index hence we return i + 1
            return i + 1;
          }
        }

        return n + 1;

    }
}