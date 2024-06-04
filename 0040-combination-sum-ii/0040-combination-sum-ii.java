class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        solve(0 , candidates , target , res , new ArrayList<>());
        return res;
    }

    private void solve(int i , int[] candidates , int target , List<List<Integer>> res , List<Integer> temp){
      if(target == 0){
        res.add(new ArrayList<>(temp));
        return;
      }

      for(int j = i ; j < candidates.length ; j++){
        if(j > i && candidates[j] == candidates[j-1]) continue;

        if(target - candidates[j] >= 0){
        temp.add(candidates[j]);
        solve(j+1 , candidates , target - candidates[j] , res , temp);
        temp.removeLast();
        }
      }


    }
}