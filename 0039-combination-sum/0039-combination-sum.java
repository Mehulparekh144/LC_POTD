class Solution {
  private void solve(int i, int[] candidates, int target, List<Integer> temp, List<List<Integer>> res) {
    if (i == candidates.length) {
      if (target == 0) {
        res.add(new ArrayList<>(temp));
      }
      return;
    }

    if (target - candidates[i] >= 0) {
      temp.add(candidates[i]);
      solve(i, candidates, target - candidates[i], temp, res);
      temp.removeLast();
    }
    solve(i + 1, candidates, target, temp, res);

  }

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<>();
    solve(0, candidates, target, new ArrayList<>(), res);
    return res;
  }
}