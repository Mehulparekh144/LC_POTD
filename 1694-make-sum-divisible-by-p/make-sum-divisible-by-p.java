class Solution {
    public int minSubarray(int[] nums, int p) {
        long sum = 0;
        for(int n : nums) sum += n;
        if(sum%p == 0) return 0;

        int rem = (int) (sum%p);

        Map<Integer,Integer> map = new HashMap<>();

        map.put(0 , -1);

        int min = Integer.MAX_VALUE;
        long pfx = 0L;
        for(int i = 0 ; i < nums.length ; i++){
          pfx += nums[i];
          int currMod = (int) (pfx % p);
          int target = (currMod - rem + p)%p;

          if(map.containsKey(target)){
            min = Math.min(min , i - map.get(target));
          }

          map.put(currMod , i);
        }

        return min == nums.length ? -1 : min;

    }
}