class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];

        for(int i = 0 ; i <= n ; i++){
          ans[i] = setBits(i);
        }

        return ans;
    }

    private int setBits(int n){
      int count = 0;

      while(n > 1){
        count += n & 1;
        n >>= 1;
      }

      if(n == 1) count++;
      return count;
    }
}