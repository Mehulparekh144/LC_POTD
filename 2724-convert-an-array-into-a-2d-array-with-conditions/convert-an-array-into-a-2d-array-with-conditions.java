class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> l = new ArrayList<>();

        while(true){
          List<Integer> temp = new ArrayList<>();
          boolean flag = true;
          for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] != -1 && !temp.contains(nums[i])){
              temp.add(nums[i]);
              nums[i] = -1;
              flag = false;
            }
          }
          if(flag) break;
          l.add(temp);
        }

        return l;
    }
}