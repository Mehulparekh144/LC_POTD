import java.util.PriorityQueue;

class Solution {

  class Pair {
    char c;
    int freq;

    public Pair(char c, int freq) {
      this.c = c;
      this.freq = freq;
    }
  }

  public String longestDiverseString(int a, int b, int c) {
    // Priority queue to keep characters sorted by their frequencies in descending
    // order
    PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> y.freq - x.freq);
    if (a > 0) {
      pq.offer(new Pair('a', a));
    }
    if (b > 0) {
      pq.offer(new Pair('b', b));
    }
    if (c > 0) {
      pq.offer(new Pair('c', c));
    }

    StringBuilder sb = new StringBuilder();

    while (!pq.isEmpty()) {
      Pair p1 = pq.poll();
      if (sb.length() > 1 && sb.charAt(sb.length() - 1) == p1.c && sb.charAt(sb.length() - 2) == p1.c) {

        if (pq.isEmpty())
          break;
        Pair p2 = pq.poll();
        sb.append(p2.c);
        p2.freq--;

        if (p2.freq > 0) {
          pq.offer(p2);
        }
      } else {
        sb.append(p1.c);
        p1.freq--;

      }
      if (p1.freq > 0) {
        pq.offer(p1);
      }
    }

    return sb.toString();
  }
}
