class Solution {
    public int minOperations(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int n : nums){
          map.put(n , map.getOrDefault(n , 0) + 1);
        }

        int res = 0;

        for(Map.Entry<Integer,Integer> e : map.entrySet()){
          int val = e.getValue();
          if(val == 1) return -1;

          res += (int) Math.ceil( (double) val/3);
        }

        return res;
    }
}