class Solution {
  public String reverseParentheses(String s) {
    Stack<Character> st = new Stack<>();

    for (char c : s.toCharArray()) {
      if (c == ')') {
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty() && st.peek() != '(') {
          sb.append(st.pop());
        }

        st.pop();
        for (int i = 0 ; i < sb.length() ; i++) {
          st.push(sb.charAt(i));
        }
      } else {
        st.push(c);
      }

    }

    StringBuilder sb = new StringBuilder();
    while(!st.isEmpty()){
      sb.append(st.pop());
    }

    sb.reverse();

    return sb.toString();
  }
}