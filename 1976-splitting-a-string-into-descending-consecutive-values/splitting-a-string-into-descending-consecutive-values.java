import java.math.BigInteger;

class Solution {
  int n;

  public boolean splitString(String s) {
    n = s.length();
    for (int i = 1; i < n; i++) {
      BigInteger firstNum = new BigInteger(s.substring(0, i));
      if (solve(i, s, firstNum)) {
        return true;
      }
    }
    return false;
  }

  private boolean solve(int i, String s, BigInteger prev) {
    if (i >= n)
      return true;

    for (int j = i; j < n; j++) {
      if (isValid(i, j, s, prev)) {
        if (solve(j + 1, s, new BigInteger(s.substring(i, j + 1)))) {
          return true;
        }
      }
    }

    return false;
  }

  private boolean isValid(int i, int j, String s, BigInteger prev) {
    BigInteger curr = new BigInteger(s.substring(i, j + 1));
    return prev.subtract(curr).equals(BigInteger.ONE);
  }
}
