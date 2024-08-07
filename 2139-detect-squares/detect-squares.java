class DetectSquares {

  Map<String, Integer> map;
  List<int[]> points;

  public DetectSquares() {
    map = new HashMap<>();
    points = new ArrayList<>();
  }

  public void add(int[] point) {
    String key = point[0] + "#" + point[1];
    if (!map.containsKey(key)) {
      points.add(point);
    }

    map.put(key, map.getOrDefault(key, 0) + 1);
  }

  public int count(int[] point) {
    int px = point[0];
    int py = point[1];
    int sum = 0;

    for (int[] dpoint : points) {
      int x = dpoint[0];
      int y = dpoint[1];

      int dx = Math.abs(px - x);
      int dy = Math.abs(py - y);

      if (x != px && y != py && dx == dy) {
        if (map.containsKey(x + "#" + py) &&
            map.containsKey(px + "#" + y) &&
            map.containsKey(x + "#" + y)) {
          sum += map.get(x + "#" + py) * map.get(px + "#" + y) * map.get(x + "#" + y);
        }
      }
    }

    return sum;

  }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */