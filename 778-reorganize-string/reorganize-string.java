class Solution {
    class Pair{
      char c;
      int freq;

      public Pair(char c , int freq){
        this.c = c;
        this.freq = freq;
      }
    }
    public String reorganizeString(String s) {
      Map<Character,Integer> map = new HashMap<>();

      for(char c : s.toCharArray()){
        map.put(c , map.getOrDefault(c , 0 ) + 1);
      }

      PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> b.freq - a.freq);

      for(Map.Entry<Character,Integer> e : map.entrySet()){
        pq.offer(new Pair(e.getKey() , e.getValue()));
      }

      String res = "";
      Pair prev = null;

      while(!pq.isEmpty()){
        Pair curr = pq.poll();

        if(prev != null && prev.freq > 0){
          pq.offer(prev);
        }

        res += curr.c;
        curr.freq--;

        prev = curr;
      }

      return res.length() == s.length() ? res : "";


    }
}