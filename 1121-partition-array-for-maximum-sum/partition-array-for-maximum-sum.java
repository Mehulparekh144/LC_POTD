class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length + 1];

        for(int i = arr.length - 1 ; i >= 0 ; i--){
          int maxi = Integer.MIN_VALUE;

          for(int j = i ; j < i + k && j < arr.length ; j++){
            int sum = getSum(arr , i , j) + dp[j+1];
            maxi = Math.max(sum , maxi);
          }

          dp[i] = maxi;
        }

        return dp[0];
    }

    // private int solve(int i , int[] arr , int k){
    //   if(i == arr.length) return 0;

    //   if(dp[i] != -1) return dp[i];

    //   int maxi = Integer.MIN_VALUE;
    //   for(int j = i ; j < i + k && j < arr.length ; j++){
    //     int sum = getSum(arr , i , j) + solve(j+1 , arr , k);
    //     maxi = Math.max(maxi , sum);
    //   }

    //   return dp[i] = maxi;
    // }

    private int getSum(int[] arr , int i , int j){
      int maxi = Integer.MIN_VALUE;

      for(int k = i ; k <= j ; k++){
        if(arr[k] > maxi) maxi = arr[k];
      }

      int sum = maxi * (j-i+1);
      return sum;
    }
}