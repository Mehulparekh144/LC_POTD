class Solution {
  private static int MOD = (int) 1e9 + 7;
    public int countOrders(int n) {
      int slots = 2*n;
      long res = 1;
      // Choices to place x*(x-1)
      // Valid choices x*(x-1)/2;
      while(slots > 0){
        int choices = slots * (slots - 1)/2;
        res = (res * choices)%MOD;
        slots -= 2;
      }

      return (int) res%MOD;

    }

}