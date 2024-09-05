class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
      int n = temperatures.length;
      Stack<Integer> st = new Stack<>();
      int[] res = new int[n];

      for(int i = n-1 ; i >= 0 ; i--){
        int temp = temperatures[i];        
        while(!st.isEmpty() && temperatures[st.peek()] <= temp ){
          st.pop();
        }

        res[i] = st.isEmpty() ? 0 : st.peek() - i;
        
        st.push(i);
      }

      return res;
    }
}