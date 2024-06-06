class Solution {
    public int[] topKFrequent(int[] nums, int k) {
      Map<Integer,Integer> map = new HashMap<>();

      for(int num : nums){
        map.put(num , map.getOrDefault(num , 0) + 1);
      }  

      PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[1] - a[1]);

      for(Map.Entry<Integer,Integer> entry : map.entrySet()){
        maxHeap.offer(new int[]{entry.getKey() , entry.getValue()});
      }

      int[] ans = new int[k];
      for(int i = 0 ; i < k && !maxHeap.isEmpty() ; i++ ){
        ans[i] = maxHeap.poll()[0];
      }

      return ans;
    }
}