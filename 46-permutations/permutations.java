class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        solve(res , nums , new ArrayList<>());
        return res;
    }

    private void solve(List<List<Integer>> res , int[] nums , List<Integer> temp){
      if(temp.size() == nums.length){
        res.add(new ArrayList<>(temp));
        return;
      }

      for(int num : nums){
        if(temp.contains(num)) continue;
        temp.add(num);
        solve(res , nums , temp);
        temp.removeLast();
      }
    }
}