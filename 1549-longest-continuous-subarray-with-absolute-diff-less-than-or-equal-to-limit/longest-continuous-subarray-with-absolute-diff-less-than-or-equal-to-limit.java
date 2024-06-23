class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int length = 0;
        int n = nums.length;

        Deque<Integer> max = new ArrayDeque<>();
        Deque<Integer> min = new ArrayDeque<>();

        int l = 0;

        for(int r = 0 ; r < n ; r++){

            while(!max.isEmpty() && nums[r] > nums[max.peekLast()]){
                max.pollLast();
            }
            max.offerLast(r);

            while(!min.isEmpty() && nums[r] < nums[min.peekLast()]){
                min.pollLast();
            }
            min.offerLast(r);


            while(nums[max.peekFirst()] - nums[min.peekFirst()] > limit){
                if(max.peekFirst() == l){
                    max.pollFirst();
                }

                if(min.peekFirst() == l){
                    min.pollFirst();
                }

                l++;
            }

            length = Math.max(length , r - l + 1);
        }

        return length;
    }



}