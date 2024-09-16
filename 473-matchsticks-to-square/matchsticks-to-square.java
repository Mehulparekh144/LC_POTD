class Solution {
    int n;
    public boolean makesquare(int[] matchsticks) {
        int perimeter = Arrays.stream(matchsticks).sum();

        if(perimeter%4 != 0) return false;
        n = matchsticks.length;
        int side = perimeter/4;
        Arrays.sort(matchsticks);
        
        return solve(n-1 , matchsticks , new int[4] , side);
    }

    private boolean solve(int i , int[] arr , int[] sums , int target){
      if(i < 0) return true;

      for(int j = 0 ; j < 4 ; j++){
        
        if(arr[i] + sums[j] > target) continue;

        sums[j] += arr[i];
        if(solve(i-1 , arr , sums , target)){
          return true;
        }
        sums[j] -= arr[i];

        if(sums[j] == 0) break;
      }

      return false;
    }
}