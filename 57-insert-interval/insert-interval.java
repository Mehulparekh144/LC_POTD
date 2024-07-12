class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
      int st = newInterval[0];
      int en = newInterval[1];
      int i = 0;
      int n = intervals.length;

      List<int[]> res = new ArrayList<>();

      while(i < n && st > intervals[i][1]){
        res.add(intervals[i++]);
      }

      while(i < n && en >= intervals[i][0]){
        st = Math.min(st , intervals[i][0]);
        en = Math.max(en , intervals[i][1]);
        i++;
      }

      res.add(new int[]{st , en});

      while(i < n){
        res.add(intervals[i++]);
      }

      int j = 0;
      int[][] ans = new int[res.size()][2];
      for(int[] interval : res){
        ans[j++] = interval;
      }
      return ans;
    }
}