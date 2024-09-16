class Solution { 
    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);        
        res = new ArrayList<>();
        solve(0 , nums , new ArrayList<>());
        return res;
    }

    private void solve(int i , int[] nums , List<Integer> temp ){
      if(i >= nums.length){
        res.add(new ArrayList<>(temp));
        return;
      }

      temp.add(nums[i]);
      solve(i+1 , nums , temp);
      temp.removeLast();

      while(i < nums.length - 1 && nums[i] == nums[i+1]){
        i++;
      }

      solve(i+1 , nums , temp);
    }
}