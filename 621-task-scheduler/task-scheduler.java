class Solution {
    public int leastInterval(char[] tasks, int n) {
      int[] freq = new int[26];

      for(char t : tasks){
        freq[t - 'A']++;
      }

    PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);

      for(int i = 0 ; i < 26 ; i++){
        if(freq[i] > 0){
          pq.offer(freq[i]);
        }
      }

      int ans = 0;
      while(!pq.isEmpty()){
        
        List<Integer> temp = new ArrayList<>();
        for(int i = 0 ; i < n + 1 ; i++){
          if(!pq.isEmpty()){
          int f = pq.poll();
          f--;
          temp.addLast(f);
        }
        }


        for(int f : temp){
          if(f > 0){
            pq.offer(f);
          }
        }

        if(pq.isEmpty()){
          ans += temp.size();
        } else{
          ans += n+1;
        }
      }

      return ans;
    }
}