class Solution {
  public long maxAlternatingSum(int[] nums) {
    long evenSum = 0;
    long oddSum = 0;

    for(int i = nums.length-1 ; i >= 0 ; i--){
      long nes = Math.max(evenSum , oddSum + nums[i]);
      long nos = Math.max(oddSum , evenSum - nums[i]);

      evenSum = nes;
      oddSum = nos;
    }

    return evenSum;

  }

}