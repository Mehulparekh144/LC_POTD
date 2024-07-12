class Solution {
  public int eraseOverlapIntervals(int[][] intervals) {
    Arrays.sort(intervals , (a,b) -> a[1] - b[1]);

  int last = intervals[0][1];

  int count = 0;

  for(int i = 1;i<intervals.length;i++)
  {
    if (last > intervals[i][0]) {
      count++;
      last = Math.min(last , intervals[i][1]);
    } else {
      last = intervals[i][1];
    }
  }

  return count;
}}