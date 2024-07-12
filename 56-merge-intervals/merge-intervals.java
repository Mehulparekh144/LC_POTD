class Solution {
    public int[][] merge(int[][] intervals) {
      Arrays.sort(intervals , (a,b) -> a[0] - b[0]);
      List<int[]> temp = new ArrayList<>();
      temp.add(intervals[0]);

      for(int i = 1 ; i < intervals.length ; i++){
        int start = intervals[i][0];
        int end = intervals[i][1];

        if(start <= temp.getLast()[1]){
          temp.getLast()[1] = Math.max(end , temp.getLast()[1]);
        } else{
          temp.add(intervals[i]);
        }
      }  

      int i = 0;
      int[][] res = new int[temp.size()][2];
      for(int[] interval : temp){
        res[i++] = interval ;
      }

      return res;
    }
}