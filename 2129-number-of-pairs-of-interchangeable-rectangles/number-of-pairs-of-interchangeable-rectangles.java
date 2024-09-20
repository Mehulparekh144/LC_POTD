class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        Map<Double,Long> map = new HashMap<>();

        for(int[] rec : rectangles){
          int w = rec[0];
          int h = rec[1];
          double val = (double)w/h;
          map.put(val , map.getOrDefault(val , 0L) + 1L);

        }

        long count = 0;
        for(Map.Entry<Double,Long> e : map.entrySet()){         
          long val = e.getValue();
          count += (val*(val-1))/2;

        }

        return count;
    }
}