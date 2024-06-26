class Solution {
    int[] dp;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        dp = new int[arr.length];
        Arrays.fill(dp , -1);
        return solve(0 , arr , k);
    }

    private int solve(int i , int[] arr , int k){
        if(i == arr.length) return 0;

        if(dp[i] != -1) return dp[i];

        int maxi = Integer.MIN_VALUE;
        for(int j = i ; j < i + k && j < arr.length ; j++){
            int sum = getSum(arr , i , j) + solve(j+1 , arr , k);
            if(sum > maxi) maxi = sum;
        }

        return dp[i] = maxi;
    }

    private int getSum(int[] arr , int i , int j){
        int maxi = Integer.MIN_VALUE;
        for(int k = i ; k <= j ; k++){
            if(arr[k] > maxi){
                maxi = arr[k];
            }
        }

        int sum = maxi * (j-i + 1);

        return sum;
    }
}