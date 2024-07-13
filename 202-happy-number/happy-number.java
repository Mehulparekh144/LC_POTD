class Solution {
    public boolean isHappy(int n) {
        int fast = n;
        int slow = n;

        do{
          slow = square(slow);
          fast = square(square(fast));
        } while(slow != fast);

        return slow == 1;
    }
    private int square(int n){

      int sum = 0;
      while(n != 0){
        int mod = n%10;
        sum += mod*mod;
        n = n/10;
      }
      return sum;
    }
}