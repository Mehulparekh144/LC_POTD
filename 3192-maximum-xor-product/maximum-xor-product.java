class Solution {
  int M = 1000000007;

  public int maximumXorProduct(long a, long b, int n) {
    long aXorx = 0;
    long bXorx = 0;

    // Setting 49 to n bits in aXorx and bXorx
    for (long i = 49; i >= n; i--) {
      boolean isA = (a & (1L << i)) > 0;
      boolean isB = (b & (1L << i)) > 0;

      if (isA) {
        aXorx = (aXorx ^ (1L << i));
      }

      if (isB) {
        bXorx = (bXorx ^ (1L << i));
      }
    }

    for (long i = n - 1; i >= 0; i--) {
      boolean isA = (a & (1L << i)) > 0;
      boolean isB = (b & (1L << i)) > 0;

      if (isA == isB) {
        aXorx = (aXorx ^ (1L << i));
        bXorx = (bXorx ^ (1L << i));
        continue;
      }

      if (aXorx > bXorx) {
        bXorx = (bXorx ^ (1L << i));
      } else {
        aXorx = (aXorx ^ (1L << i));
      }
    }

    aXorx %= M;
    bXorx %= M;

    return (int) ((aXorx * bXorx) % M);
  }
}