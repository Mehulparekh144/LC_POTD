class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
      int n = popped.length;
      int i = 0;
      Stack<Integer> st = new Stack<>();

      for(int num : pushed){
        st.push(num);

        while(i < n && !st.isEmpty() && popped[i] == st.peek()){
          st.pop();
          i++;
        }
      }

      return st.isEmpty();
    }
}