class Solution {
  List<List<Integer>> res;

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    res = new ArrayList<>();
    solve(0, candidates, target, new ArrayList<>());
    return res;
  }

  private void solve(int i, int[] candidates, int target, List<Integer> temp) {
    if (i >= candidates.length) {
      if (target == 0) {
        res.add(new ArrayList<>(temp));
      }
      return;
    }

    if (candidates[i] <= target) {
      temp.add(candidates[i]);
      solve(i, candidates, target - candidates[i], temp);
      temp.removeLast();
    }

    solve(i + 1, candidates, target, temp);


  }
}