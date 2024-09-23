class Solution {
  public int partitionString(String s) {
    StringBuilder sb = new StringBuilder();
    int ans = 0;

    for (char c : s.toCharArray()) {
      if (sb.indexOf(String.valueOf(c)) != -1) {
        ans++;
        sb.setLength(0);
      }

      sb.append(c);
    }

    if (!sb.isEmpty())
      ans++;

    return ans;
  }
}