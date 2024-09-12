class Solution {
  public int countConsistentStrings(String allowed, String[] words) {
    int count = 0;
    Set<Character> set = new HashSet<>();
    for (char c : allowed.toCharArray()) {
      set.add(c);
    }

    for (String w : words) {
      boolean flag = false;
      for (char c : w.toCharArray()) {
        if (!set.contains(c)) {
          flag = true;
        }
      }

      if (!flag) {
        count++;
      }
    }

    return count;
  }
}