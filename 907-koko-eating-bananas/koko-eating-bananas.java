class Solution {
    public int minEatingSpeed(int[] piles, int h) {
      int l = 0;
      int r = Arrays.stream(piles).max().getAsInt();
      int res = 0;
      while(l <= r ){
        int m = l + ((r-l) >> 1);

        if(canEat(m , piles , h)){
          res = m;
          r = m - 1;
        } else{
          l = m + 1;
        }
      }   

      return res;
    }

    private boolean canEat(int k , int[] piles , int h){
      int sum = 0;

      for(int p : piles){
        sum += Math.ceil(1.0 * p/k);
      }

      return sum <= h;
    }
}