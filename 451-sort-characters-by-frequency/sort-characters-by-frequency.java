class Pair{
  char ch;
  int freq;

  public Pair(char ch , int freq){
    this.ch = ch;
    this.freq=  freq;
  }
}
class Solution {
    public String frequencySort(String s) {
      int[] freq = new int[128];

      for(char c : s.toCharArray()){
        freq[c]++;
      }

      PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> b.freq - a.freq);

      for(int i = 0 ; i < 128 ; i++){
        if(freq[i] > 0){
          pq.offer(new Pair((char) i , freq[i]));
        }
      }

      String res = "";

      while(!pq.isEmpty()){
        char ch = pq.peek().ch;

        for(int x = 0 ; x < pq.peek().freq ; x++){
          res += ch;
        }

        pq.poll();
      }

      return res;
    }
}