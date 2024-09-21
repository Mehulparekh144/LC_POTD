class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;

        for(int i = 0 ; i < nums.length ; i++){
          sum += nums[i];
          sum %= k;

          if(sum == 0 && i > 0) return true;

          // Map stores remainder and index it was encountered, so if its encountered once again and the distance between current i and map.get(sum) is greater than 1 that means it has atleast 2 elements.
          if(map.containsKey(sum) && i - map.get(sum) > 1  ){
            return true;
          }

          if(!map.containsKey(sum)){
            map.put(sum , i);
          }
        }

        return false;
    }
}