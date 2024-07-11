class Solution {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<>();
    int n = candidates.length;
    solve(n - 1, candidates, target, res, new ArrayList<>());
    return res;
  }

  private void solve(int i, int[] nums, int target, List<List<Integer>> res, List<Integer> temp) {
    if (i < 0) {
      if (target == 0) {
        res.add(new ArrayList<>(temp));
      }

      return;
    }

    if(nums[i] <= target){
      temp.add(nums[i]);
      solve(i , nums , target - nums[i] , res , temp);
      temp.removeLast();
    }
    solve(i-1 , nums , target , res , temp);
  }
}