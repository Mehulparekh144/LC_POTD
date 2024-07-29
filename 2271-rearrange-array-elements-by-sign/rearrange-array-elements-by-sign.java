class Solution {
  public int[] rearrangeArray(int[] nums) {
    List<Integer> pos = new ArrayList<>();
    List<Integer> neg = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] >= 0) {
        pos.addLast(nums[i]);
      } else {
        neg.addLast(nums[i]);
      }
    }


    int i = 0;
    while(2*i < nums.length){
      nums[2*i] = pos.get(i);
      nums[2*i + 1] = neg.get(i);
      i++;
    }


    return nums;

  }
}