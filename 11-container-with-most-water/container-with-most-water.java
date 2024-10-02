class Solution {
    public int maxArea(int[] heights) {
        int max = 0;
        int n = heights.length;
        int l = 0;
        int r = n-1;

        while(l < r){
          int area = Math.min(heights[l] , heights[r]) * (r-l);
          max = Math.max(area , max);

          if(heights[l] > heights[r]){
            r--;
          } else{
            l++;
          }
        }

        return max;
    }
}