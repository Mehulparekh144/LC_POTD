class Solution {
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> res = new ArrayList<>();
    solve(0, candidates, target, res, new ArrayList<>());
    return res;
  }

  private void solve(int i, int[] nums, int target, List<List<Integer>> res, List<Integer> temp) {

    if (target == 0) {
      res.add(new ArrayList<>(temp));
      return;
    }

    for (int j = i; j < nums.length; j++) {
      if(j > i && nums[j] == nums[j-1] ) continue;

      if (nums[j] <= target) {
        temp.add(nums[j]);
        solve(j+1, nums, target - nums[j], res, temp);
        temp.removeLast();
      }
    }

  }
}