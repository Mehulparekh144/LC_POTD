class Solution {
  public int minimumDeviation(int[] nums) {
    // 1. Make all the values even.
    int n = nums.length;
    for(int i = 0 ; i < n ; i++){
      if(nums[i]%2 != 0){
        nums[i] *= 2;
      }
    }

    // 2. Get the minimum value;
    int mini = Arrays.stream(nums).min().getAsInt();

    // 3. Get the max -> divide by 2 if even -> get the difference.
    int diff = Integer.MAX_VALUE;
    PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);

    for(int num : nums) pq.offer(num);

    while(!pq.isEmpty()){
      int maxi = pq.poll();
      diff = Math.min(
          diff ,
          maxi - mini
      );
      
      if(maxi%2 != 0) break;

      pq.offer(maxi/2);
      mini = Math.min(mini , maxi/2);
    }

    return diff;
  }
}