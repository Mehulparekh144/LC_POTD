class Solution {
    public int findMaxK(int[] nums) {
       Arrays.sort(nums);
       int j = nums.length - 1;

       while(j >= 0){
        int target = nums[j];
        for(int num : nums){
            if(target*-1 == num) return target;
        }
        j--;
       }

       return -1;

    }
}