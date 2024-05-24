class Solution {
  public String minWindow(String s, String t) {
    if (s.length() < t.length())
      return "";
    Map<Character, Integer> smap = new HashMap<>();
    Map<Character, Integer> tmap = new HashMap<>();

    for (char c : t.toCharArray()) {
      tmap.put(c, tmap.getOrDefault(c, 0) + 1);
    }
    int have = 0;
    int need = tmap.size();
    int l = 0;
    int length = Integer.MAX_VALUE;
    int start = 0;

    for (int r = 0; r < s.length(); r++) {
      char c = s.charAt(r);
      smap.put(c, smap.getOrDefault(c, 0) + 1);

      if (tmap.containsKey(c) && smap.get(c).equals(tmap.get(c))) {
        have++;
      }

      while (have == need) {
        if (r - l + 1 < length) {
          length = r - l + 1;
          start = l;
        }
        char leftC = s.charAt(l);
        smap.put(leftC, smap.get(leftC) - 1);
        if (tmap.containsKey(leftC) && smap.get(leftC) < tmap.get(leftC)) {
          have--;
        }
        l++;
      }
    }

    return length == Integer.MAX_VALUE ? "" : s.substring(start, start + length);

  }
}