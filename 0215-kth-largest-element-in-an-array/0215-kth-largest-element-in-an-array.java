class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int num : nums){
          pq.offer(num);
        }

        int num = 0;
        while(k > 0){
          num = pq.poll();
          k--;
        }

        return num;
    }
}