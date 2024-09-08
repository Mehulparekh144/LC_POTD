class FreqStack {
    Map<Integer,Stack<Integer>> st;
    Map<Integer,Integer> map;
    int maxFreq;

    public FreqStack() {
      map = new HashMap<>();
      st = new HashMap<>();
      maxFreq = 0;
    }
    
    public void push(int val) {
      map.put(val , map.getOrDefault(val , 0) + 1);
      int valCnt = map.get(val);

      if(valCnt > maxFreq){
        maxFreq = valCnt;
        st.put(valCnt , new Stack<>());
      }

      st.get(valCnt).push(val);

    }
    
    public int pop() {
      int ans = st.get(maxFreq).pop();
      map.put(ans , map.get(ans) - 1);
      if(st.get(maxFreq).isEmpty()){
        maxFreq -= 1;
      }

      return ans;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */