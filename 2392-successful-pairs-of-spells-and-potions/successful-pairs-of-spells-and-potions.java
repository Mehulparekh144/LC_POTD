class Solution {
  public int[] successfulPairs(int[] spells, int[] potions, long success) {
    Arrays.sort(potions);
    int n = spells.length;
    int[] res = new int[n];

    for (int i = 0; i < n; i++) {
      int spell = spells[i];
      int count = 0;
      int l = 0;
      int r = potions.length - 1;

      while (l <= r) {
        int m = l + (r - l) / 2;
        long curr = (long) potions[m] * spell;


        if (curr >= success) {
          count = potions.length - m ;
          r = m - 1;
        } else {
          l = m + 1;
        }
      }

      res[i] = count;
    }

    return res;
  }
}