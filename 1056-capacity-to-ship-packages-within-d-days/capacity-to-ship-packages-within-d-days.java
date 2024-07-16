class Solution {
  public int shipWithinDays(int[] weights, int days) {
    int max = Arrays.stream(weights).max().getAsInt();
    int sum = Arrays.stream(weights).sum();

    int l = max;
    int r = sum;
    int res = 0;

    while (l <= r) {
      int mid = l + (r - l) / 2;

      if (isPossible(mid, days, weights)) {
        res = mid;
        r = mid - 1;
      } else {
        l = mid + 1;
      }
    }

    return res;
  }

  private boolean isPossible(int maxWeight, int days, int[] weights) {
    int count = 1;
    int sum = 0;
    for (int weight : weights) {
      sum += weight;
      if (sum > maxWeight) {
        count++;
        sum = weight;
      }
    }

    return count <= days;
  }
}