class Solution {
    Set<List<Integer>> res;
    public void solve(int i , int[] nums , List<Integer> subset){
      if(i == nums.length){
        res.add(new ArrayList<>(subset));
        return;
      }

      subset.add(nums[i]);
      solve(i+1 , nums, subset);
      subset.remove(subset.size() - 1);
      solve(i+1 , nums, subset);
    }
    public List<List<Integer>> subsets(int[] nums) {
        res = new HashSet<>();
        solve(0 , nums , new ArrayList<>());
        return new ArrayList<>(res);
    }
}