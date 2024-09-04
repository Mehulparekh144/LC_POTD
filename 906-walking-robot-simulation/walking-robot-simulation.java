class Solution {
  public int robotSim(int[] commands, int[][] obstacles) {
    int[][] dirs = {
        // Maintain this order
        // N E S W
        { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }
    };

    Set<List<Integer>> set = new HashSet<>();
    for (int[] obstacle : obstacles) {
      set.add(List.of(obstacle[0], obstacle[1]));
    }

    int x = 0, y = 0;
    int idx = 0;
    int max = 0;

    for (int command : commands) {
      if (command == -1) {
        idx = (idx + 1) % 4;
      } else if (command == -2) {
        idx = (idx - 1 + 4) % 4;
      } else {

        for (int i = 0; i < command; i++) {
          int newx = x + dirs[idx][0];
          int newy = y + dirs[idx][1];

          if (set.contains(List.of(newx, newy))) {
            break;
          }

          x = newx;
          y = newy;

          max = Math.max(max, x * x + y * y);
        }

      }

    }

    return max;

  }
}