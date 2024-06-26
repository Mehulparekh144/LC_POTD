class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length + 1];

        for(int i = arr.length - 1 ; i >= 0 ; i--){
            int maxi = Integer.MIN_VALUE;
            for(int j = i ; j < i + k && j < arr.length ; j++){
                int sum = getSum(arr , i , j) + dp[j+1];
                if(sum > maxi) maxi = sum;
            }

            dp[i] = maxi;
        }

        return dp[0];
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