class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
      int length[]  = new int[1001];

      for(int[] trip : trips){
        length[trip[1]] += trip[0]; // Boarding
        length[trip[2]] -= trip[0]; // Leaving
      }

      int load = 0;
      for(int i = 0 ; i < 1001 ; i++){
        load += length[i];

        if(load > capacity) return false;
      }

      return true;
    }
}