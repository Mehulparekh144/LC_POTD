class Solution {
  public String predictPartyVictory(String senate) {
    int n = senate.length();
    char[] arr = senate.toCharArray();
    Queue<Integer> dire = new LinkedList<>();
    Queue<Integer> radiant = new LinkedList<>();
    
    for(int i = 0 ; i < n ; i++){
      if(arr[i] == 'D'){
        dire.offer(i);
      } else{
        radiant.offer(i);
      }
    }

    while(!dire.isEmpty() && !radiant.isEmpty()){
      int dIdx = dire.poll();
      int rIdx = radiant.poll();

      if(dIdx > rIdx){
        radiant.offer(rIdx + n);
      } else{
        dire.offer(dIdx + n);
      }
    }

    return radiant.isEmpty() ? "Dire" : "Radiant";
  }
}