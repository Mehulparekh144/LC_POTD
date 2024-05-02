class Solution {
    public int findMaxK(int[] nums) {
       Arrays.sort(nums);
       int j = nums.length - 1;

       while(j >= 0){
        int target = nums[j];
        if(binarySearch(nums , target*-1) != Integer.MAX_VALUE) return target;
        j--;
       }

       return -1;
    }

    public int binarySearch(int[] nums , int target){
        int l = 0 ;
        int r = nums.length - 1;

        while(l <= r){
            int mid = l + (r-l)/2;
            if(nums[mid] == target){
                return target;
            }

            else if(nums[mid] < target){
                l = mid + 1;
            }

            else{
                r = mid - 1;
            }
        }

        return Integer.MAX_VALUE;
    }
}