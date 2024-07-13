class Solution {
  class Pair {
    int position;
    int health;
    char direction;
    int idx;

    public Pair(int position, int health, char direction , int idx) {
      this.position = position;
      this.health = health;
      this.direction = direction;
      this.idx = idx;
    }
  }

  public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
    List<Pair> combined = new ArrayList<>();
    for (int i = 0; i < healths.length; i++) {
      combined.add(new Pair(positions[i], healths[i], directions.charAt(i) , i));
    }

    Collections.sort(combined, Comparator.comparingInt(p -> p.position));

    Stack<Pair> st = new Stack<>();
    for (Pair robot : combined) {
      while (!st.isEmpty() && st.peek().direction == 'R' && robot.direction == 'L') {
        Pair top = st.peek();
        if (top.health == robot.health) {
          st.pop();
          robot = null;
          break;
        } else if (top.health > robot.health) {
          top.health--;
          robot = null;
          break;
        } else {
          st.pop();
          robot.health--;
        }
      }
      if (robot != null) {
        st.push(robot);
      }
    }
    List<Pair> survivors = new ArrayList<>(st);
    survivors.sort(Comparator.comparingInt(p -> p.idx));

    List<Integer> result = new ArrayList<>();
    for (Pair robot : survivors) {
      result.add(robot.health);
    }


    return result;
  }
}