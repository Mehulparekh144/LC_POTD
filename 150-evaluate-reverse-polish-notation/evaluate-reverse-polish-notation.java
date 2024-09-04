class Solution {
    public int evalRPN(String[] tokens) {
      Stack<Integer> st = new Stack<>();

      List<String> operators = new ArrayList<>(List.of("+" , "-" , "/" , "*"));

      for(String token : tokens){
        if(operators.contains(token)){
          int n2 = st.pop();
          int n1 = st.pop();

          if(token.equals("+")){
            st.push(n1 + n2);
          } else if(token.equals("-")){
            st.push(n1 - n2);
          } else if(token.equals("*")){
            st.push(n1*n2);
          } else{
            st.push(n1/n2);
          }
        } else{
          st.push(Integer.parseInt(token));
        }
      }

      return st.peek();
    }
}