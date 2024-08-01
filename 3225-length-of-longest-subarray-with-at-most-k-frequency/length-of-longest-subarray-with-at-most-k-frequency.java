class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
      Map<Integer,Integer> map = new HashMap<>();

      int len = 0;
      int l = 0;

      for(int r = 0 ; r < nums.length ; r++){
        map.put(nums[r] , map.getOrDefault(nums[r] , 0) + 1);

        while(map.get(nums[r]) > k){
          map.put(nums[l] , map.get(nums[l]) - 1);
          if(map.get(nums[l]) == 0){
            map.remove(nums[l]);
          }
          l++;
        }

        len = Math.max(len , r - l + 1);
      }

      return len;
    }
}