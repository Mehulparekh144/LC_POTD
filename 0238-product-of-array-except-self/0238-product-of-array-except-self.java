class Solution {
    public int[] productExceptSelf(int[] nums) {
      int[] left = new int[nums.length];
      int[] right = new int[nums.length];
      int l = 1;
      int r = 1;

      for(int i = 0 ; i < nums.length; i++ ){
        left[i] = l;
        l*= nums[i]; 
      }  

      for(int j = nums.length - 1 ; j>= 0 ; j--){
        right[j] = r;
        r*= nums[j];
      }

      int[] ans = new int[nums.length];
      for(int i = 0 ; i < nums.length ; i++){
        ans[i] = left[i]*right[i];
      }

      return ans;

    }
}