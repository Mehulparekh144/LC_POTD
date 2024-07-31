class Solution {
  public int minFlips(String s) {
    StringBuilder alt1 = new StringBuilder();
    StringBuilder alt2 = new StringBuilder();

    int n = s.length();
    if (n % 2 != 0) {
      s += s;
    }

    for (int i = 0; i < s.length(); i++) {
      alt1.append(i % 2 == 0 ? "1" : "0");
      alt2.append(i % 2 == 0 ? "0" : "1");
    }

    int l = 0;
    int diff1 = 0;
    int diff2 = 0;
    int res = s.length();

    for (int r = 0; r < s.length(); r++) {
      char c = s.charAt(r);
      char a1 = alt1.charAt(r);
      char a2 = alt2.charAt(r);

      if (c != a1) {
        diff1++;
      }

      if (c != a2) {
        diff2++;
      }

      if (r - l + 1 > n) {
        char c2 = s.charAt(l);
        if (c2 != alt1.charAt(l)) {
          diff1--;
        }

        if (c2 != alt2.charAt(l)) {
          diff2--;
        }

        l++;
      }

      if (r - l + 1 == n) {
        res = Math.min(res, Math.min(diff1, diff2));
      }
    }

    return res;
  }
}