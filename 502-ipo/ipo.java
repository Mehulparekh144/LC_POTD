class Solution {
  public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
    int n = profits.length;
    // Keep track of capital
    PriorityQueue<int[]> min = new PriorityQueue<>((a, b) -> a[1] - b[1]);

    for (int i = 0; i < n; i++) {
      min.offer(new int[] { profits[i], capital[i] });
    }
    // Keep track of profits as we need max
    PriorityQueue<int[]> max = new PriorityQueue<>((a,b) -> b[0] - a[0]);

    while(k > 0){

      while(!min.isEmpty() && min.peek()[1] <= w){
        max.offer(min.poll());
      }

      if(max.isEmpty()) break;

      w += max.poll()[0];
      k--;
    }

    return w;
  }
}