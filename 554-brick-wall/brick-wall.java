class Solution {
  public int leastBricks(List<List<Integer>> wall) {
    Map<Integer, Integer> map = new HashMap<>();

    for (List<Integer> row : wall) {
      int pfx = 0;
      for (int i = 0; i < row.size() - 1; i++) {

        pfx += row.get(i);
        map.put(pfx, map.getOrDefault(pfx, 0) + 1);
      }
    }

    int maxEdges = 0;
    for (int count : map.values()) {
      maxEdges = Math.max(maxEdges, count);
    }

    return wall.size() - maxEdges;

  }
}