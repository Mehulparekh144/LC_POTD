class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int num : nums){
          map.put(num , map.getOrDefault(num , 0) + 1);
        }

        Integer[] numsObj = new Integer[nums.length];

        int idx = 0;
        for(int num : nums){
          numsObj[idx++] = num;
        }

        Arrays.sort(numsObj , (a,b) -> {
          if(map.get(a).equals(map.get(b))){
            return b-a;
          } else{
            return map.get(a) - map.get(b);
          }
        });

        idx = 0;
        for(int num : numsObj){
          nums[idx++] = num;
        }

        return nums;

    }
}