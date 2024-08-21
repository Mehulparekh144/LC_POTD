class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
      
      int n = nums.length;
      int count = 0;
      long sum = 0;

      // Calculate the minimum value to be subtracted.
      // If there are odd number of count that means one is not an edge. So we have to minus it so that's why we keep min inorder to minus it with the sum as we dnt consider it

      long min = Integer.MAX_VALUE;

      for(int num : nums){
        if((num^k) > num){
          count++;
          sum += num^k;
        } else{
          sum += num;
        }

        min = Math.min(min , Math.abs((num^k) - num));
      }

      if(count%2 == 0){
        return sum;
      }

      return sum - min;
    }
}