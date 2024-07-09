class Solution {
  public int leastInterval(char[] tasks, int n) {
    int[] count = new int[26];

    for (char c : tasks) {
      count[ c - 'A']++;
    }

    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

    for (int i = 0; i < 26; i++) {
      if (count[i] > 0) {
        pq.offer(count[i]);
      }
    }

    int time = 0;

    while (!pq.isEmpty()) {
      List<Integer> temp = new ArrayList<>();
      for (int i = 0; i < n + 1; i++) {

        if (!pq.isEmpty()) {
          int f = pq.poll();
          f--;
          temp.addLast(f);
        }
      }

      for (int freq : temp) {
        if (freq > 0) {
          pq.offer(freq);
        }
      }

      if(pq.isEmpty()){
        time += temp.size();
      } else{
        time += n+1;
      }
    }

    return time;

  }
}