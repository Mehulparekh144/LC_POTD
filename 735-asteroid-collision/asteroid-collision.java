class Solution {
  public int[] asteroidCollision(int[] asteroids) {
    Stack<Integer> st = new Stack<>();

    for (int a : asteroids) {

      boolean destroyed = false;

      while (!st.isEmpty() && st.peek() > 0 && a < 0) {
        // st.peek() is smaller so pop
        if (st.peek() + a < 0) {
          st.pop();
        }
        // a is smaller so do nothing just break out of while loop
        else if (st.peek() + a > 0) {
          destroyed = true;
          break;
        }
        // both equal so popout and break
        else if (st.peek() + a == 0) {
          destroyed = true;
          st.pop();
          break;
        }
      }

      if (!destroyed) {
        st.push(a);
      }

    }

    int idx = st.size() - 1;
    int[] ans = new int[st.size()];

    while (!st.isEmpty()) {
      ans[idx--] = st.pop();
    }

    return ans;
  }
}