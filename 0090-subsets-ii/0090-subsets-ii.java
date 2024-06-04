class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        solve(0 , nums, res , new ArrayList<>() );
        return res;
    }

    private void solve(int i , int[] nums, List<List<Integer>> res , List<Integer> temp){
      if(i == nums.length){
        res.add(new ArrayList<>(temp));
        return;
      }

      temp.add(nums[i]);
      solve(i+1 , nums , res , temp);
      temp.removeLast();

      while (i+1 < nums.length && nums[i] == nums[i+1]){
        i++;
      }

      solve(i+1 , nums, res , temp);
    }
}