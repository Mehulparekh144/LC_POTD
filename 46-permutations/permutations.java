class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        solve(nums , res , new ArrayList<>());
        return res;
    }

    private void solve(int[] nums , List<List<Integer>> res , List<Integer> temp){
      if(nums.length == temp.size()){
        res.add(new ArrayList<>(temp));
        return;
      }

      for(int num : nums){
        if(temp.contains(num)) continue;
        temp.add(num);
        solve(nums , res , temp);
        temp.removeLast();
      }
    }
}