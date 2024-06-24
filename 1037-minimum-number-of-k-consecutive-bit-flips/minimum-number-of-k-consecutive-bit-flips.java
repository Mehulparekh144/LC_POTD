class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int flips = 0;
        int n = nums.length;

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0 ; i < n ; i++){
            if(!q.isEmpty() && q.peek() < i){
                q.poll();
            }

            if(q.size()%2 == nums[i]){
                if(i+k-1 >= n) return -1;

                q.offer(i+k-1);
                flips++;
            }
        }

        return flips;

    }
}