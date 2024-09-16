class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        res = new ArrayList<>();
        solve(nums , new ArrayList<>() , new ArrayList<>());
        return res;
    }

    private void solve(int[] nums , List<Integer> temp , List<Integer> indices){
      if(nums.length == temp.size()){
        res.add(new ArrayList<>(temp));
        return;
      }

      for(int i = 0 ; i < nums.length ; i++){
        if(indices.contains(i)) continue;

        temp.add(nums[i]);
        indices.add(i);
        solve(nums , temp , indices);
        indices.removeLast();
        temp.removeLast();

        while(i < nums.length - 1 && nums[i] == nums[i+1] ){
          i++;
        }

      }


    }
}