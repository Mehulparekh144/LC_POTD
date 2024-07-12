class Solution {
  public int maximumGain(String s, int x, int y) {
    if (x > y) {
      return solve('a', 'b', y, x, s);
    }

    return solve('b', 'a', x, y, s);

  }

  private int solve(char c1, char c2, int x, int y, String s) {
    Stack<Character> st = new Stack<>();
    int score = 0;
    for (char c : s.toCharArray()) {

      if (!st.isEmpty() && st.peek() == c1 && c == c2) {
        score += y;
        st.pop();
      } else {
        st.push(c);
      }
    }

    String remain = "";
    while (!st.isEmpty()) {
      remain += st.pop();
    }

    for (char c : remain.toCharArray()) {

      if (!st.isEmpty() && st.peek() == c1 && c == c2) {
        score += x;
        st.pop();
      } else {
        st.push(c);
      }
    }

    return score;
  }
}