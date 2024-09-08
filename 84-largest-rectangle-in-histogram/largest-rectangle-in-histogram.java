class Solution {
  public int largestRectangleArea(int[] nums) {
    int n = nums.length;

    int[] nsl = new int[n];
    int[] nsr = new int[n];
    Stack<Integer> st = new Stack<>();

    for (int i = 0; i < n; i++) {

      while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
        st.pop();
      }
      if (st.isEmpty()) {
        nsl[i] = -1;
      } else {
        nsl[i] = st.peek();
      }

      st.push(i);
    }

    st.clear();

    for (int i = n - 1; i >= 0; i--) {

      while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
        st.pop();
      }

      if (st.isEmpty()) {
        nsr[i] = n;
      } else {
        nsr[i] = st.peek();
      }

      st.push(i);
    }

    int max = 0;
    for (int i = 0; i < n; i++) {
      int area = (nsr[i] - nsl[i] - 1) * nums[i];
      max = Math.max(max, area);
    }

    return max;
  }
}