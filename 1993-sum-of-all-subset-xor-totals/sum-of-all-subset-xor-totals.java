class Solution {
  int res;

  public int subsetXORSum(int[] nums) {
    res = 0;
    solve(0, nums, 0);
    return res;
  }

  private void solve(int i , int[] nums , int xor){
      if(i >= nums.length){
        res += xor;
        return;
      }

      solve(i+1 , nums , xor^nums[i]);
      solve(i+1 , nums , xor);
    }
}