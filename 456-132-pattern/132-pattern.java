class Solution {
  public boolean find132pattern(int[] nums) {
    int n = nums.length;
    Stack<int[]> st = new Stack<>(); // num , minLeft
    int currMin = nums[0];

    for (int k = 1; k < n; k++) {
      while (!st.isEmpty() && nums[k] >= st.peek()[0]) {
        st.pop();
      }

      // if (!st.isEmpty() && nums[k] < st.peek()[0] && nums[k] > st.peek()[1]) 
      // if k > st.peek()[1] and since stack is monotonically decreasing it'll be k < st.peek()[0]
      if (!st.isEmpty() && nums[k] > st.peek()[1]) 
      {
        return true;
      }

      st.push(new int[] { nums[k], currMin });
      currMin = Math.min(currMin, nums[k]);
    }

    return false;
  }
}