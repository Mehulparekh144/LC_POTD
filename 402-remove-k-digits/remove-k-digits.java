class Solution {
  public String removeKdigits(String num, int k) {
    Stack<Integer> st = new Stack<>();

    for(char c : num.toCharArray()){
      int n = c - '0';
      while(!st.isEmpty() && k > 0 &&  n < st.peek() ){
        st.pop();
        k--;
      }
      
      st.push(n);
    }

    while(k > 0){
      st.pop();
      k--;
    }

    System.out.println(st);

    StringBuilder sb = new StringBuilder();
    for(int n : st){
      if(sb.isEmpty() && n == 0) continue;
      sb.append(n);
    }

    if(sb.isEmpty()) return "0";

    return sb.toString();
  }
}