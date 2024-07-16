class Solution {
    public int arrangeCoins(int n) {
      int l = 1;
      int r = n;
      int res = 0;

      while(l <= r){
        int mid = l + (r-l)/2;

        double sum = (double) mid /2 * (mid + 1);

        if(sum == n){
          return mid;
        } else if(sum > n){
          r = mid - 1;
        } else{
          l = mid + 1;
        }
      }

      return l-1;
    }
}