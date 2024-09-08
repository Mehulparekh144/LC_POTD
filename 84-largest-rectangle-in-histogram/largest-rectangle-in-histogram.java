class Solution {
  public int largestRectangleArea(int[] nums) {
    int n = nums.length;
    Stack<Integer> st = new Stack<>();
    int max = 0;
    for (int i = 0; i <= n; i++) {

      while (!st.isEmpty() && (i == n || nums[st.peek()] >= nums[i])) {
        // This condition means that we have found the next smaller element on the right side
        // 2 1 5 6 now 2 comes so for 5 6, 2 is the next smaller
        
        int h = nums[st.pop()];
        int w = 0;

        if(st.isEmpty()){
          // That means the current element is the nsl so whatever till this index is the width will be that
          //eg. 5 1 1
          // at index 2, st will be empty so 1 is the min height so all 3 elements will be considered
          w = i;
        } else{
          w = i - st.peek() - 1;
        }

        max = Math.max(max , h*w);
      }

      st.push(i);
    }

    return max;
  }
}