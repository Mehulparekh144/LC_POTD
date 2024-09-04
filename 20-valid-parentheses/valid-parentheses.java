class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        Map<Character,Character> map = new HashMap<>();

        map.put(')' , '(');
        map.put('}' , '{');
        map.put(']' , '[');

        for(char c : s.toCharArray()){
          if(c == ')' || c == ']' || c == '}'){
            if(st.isEmpty()){
              return false;
            } else {
              if(st.peek() != map.get(c)){
                return false;
              } 
              st.pop();
            }
          } else{
            st.push(c);
          }
        }

        return st.isEmpty();
    }
}