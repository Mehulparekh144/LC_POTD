class Solution {
  public int[] missingRolls(int[] rolls, int mean, int n) {
    int sum = Arrays.stream(rolls).sum();

    int remain = mean * (rolls.length + n) - sum;

    if (remain < n || remain > 6 * n) {
      return new int[] {};
    }

    if (remain % n == 0) {
      int[] res = new int[n];
      Arrays.fill(res, remain / n);
      return res;
    }

    int remainder = remain % n;
    int[] res = new int[n];
    Arrays.fill(res, remain / n);

    int i = n - 1;
    while (remainder > 0) {
      while (i >= 0 && res[i] + 1 > 6) {
        i--;
      }

      int diff = Math.min(6 - res[i], remainder);
      res[i] += diff;
      remainder -= diff;

    }

    return res;
  }
}