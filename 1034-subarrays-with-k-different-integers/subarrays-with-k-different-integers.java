class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
       return window(nums , k) - window(nums , k-1); 
    }

    private int window(int[] nums , int k){
      int l = 0;
      HashSet<Integer> set = new HashSet<>();
      Map<Integer,Integer> map = new HashMap<>();

      int res = 0;

      for(int r = 0 ; r < nums.length ; r++){
        set.add(nums[r]);
        map.put(nums[r] , map.getOrDefault(nums[r] , 0 ) + 1);

        while(set.size() > k){
          map.put(nums[l] , map.get(nums[l]) - 1);
          if(map.get(nums[l]) == 0) {
            map.remove(nums[l]);
            set.remove(nums[l]);
          }
          l++;
        }

        res += r-l+1;
      }

      return res;
    }
}