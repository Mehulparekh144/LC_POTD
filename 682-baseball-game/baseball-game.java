class Solution {
    public int calPoints(String[] operations) {
      Stack<Integer> st = new Stack<>();
      int sum = 0;

      for(String s : operations){
        if(s.equals("+")){
          int n1 = st.pop();
          int n2 = st.pop();
          
          st.push(n2);
          st.push(n1);
          st.push(n1 + n2);
        } else if(s.equals("C")){
          sum -= st.peek();
          st.pop();
          continue;
        } else if(s.equals("D")){
          st.push(st.peek()*2);
        } else{
          st.push(Integer.parseInt(s));
        }

        sum += st.peek();
      }

      return sum;

  
    }

}