class Solution {
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> res = new ArrayList<>();
    solve(nums.length - 1, nums, res, new ArrayList<>());
    return res;
  }

  private void solve(int i , int[] nums , List<List<Integer>> res , List<Integer> temp){
      if(i < 0){
        res.add(new ArrayList<>(temp));
        return;
      }

      temp.add(nums[i]);
      solve(i-1 , nums , res , temp);
      temp.removeLast();

      while(i > 0 && nums[i] == nums[i-1]){
        i--;
      }

      solve(i-1 , nums , res , temp);
    }
}