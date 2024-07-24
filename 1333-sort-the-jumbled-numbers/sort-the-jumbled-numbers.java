class Solution {
  public int[] sortJumbled(int[] mapping, int[] nums) {
    int[] res = new int[nums.length];
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
      if (a[0] == b[0])
        return a[2] - b[2];
      return a[0] - b[0];
    });

    for (int i = 0 ; i < nums.length ; i++) {
      int n = nums[i];
      int mapped = 0;
      int power = 0;
      int original = n;
      if (n == 0) {
        mapped = mapping[n];
      } else {
        while (n != 0) {
          int rem = n % 10;
          mapped += (int) (mapping[rem] * Math.pow(10, power++));
          n /= 10;
        }

      }

      pq.offer(new int[] { mapped, original, i });

    }

    int idx = 0;
    while (!pq.isEmpty()) {
      res[idx++] = pq.poll()[1];
    }

    return res;
  }
}