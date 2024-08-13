class Solution {


  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> res = new ArrayList<>();
    dfs(0, candidates, target, new ArrayList<>() , res);
    return res;
  }

  private void dfs(int i, int[] candidates, int target, List<Integer> temp , List<List<Integer>> res) {
    if (target == 0) {
      res.add(new ArrayList<>(temp));
      return;
    }

    for(int j = i ; j < candidates.length ; j++){
      if(j > i && candidates[j] == candidates[j-1]) continue;

      if(target >= candidates[j]){
        temp.add(candidates[j]);
        dfs(j+1 , candidates , target - candidates[j] , temp , res);
        temp.removeLast();
      }
    }
  }
}