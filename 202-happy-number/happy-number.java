class Solution {
    public boolean isHappy(int n) {
        Set<Integer> nums = new HashSet<>();

        while(n != 1){
          if(nums.contains(n)) return false;
          nums.add(n);
          n = square(n);
        }

        return true;
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