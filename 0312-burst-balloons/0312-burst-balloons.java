class Solution {
    public int maxCoins(int[] nums) {
        int[][] dp = new int[nums.length + 2][nums.length + 2];
        List<Integer> numsL = new ArrayList<>();
        for(int num : nums){
            numsL.add(num);
        }
        numsL.add(1);
        numsL.add(0 , 1);

        for(int i = nums.length ; i >= 1 ; i--){
            for(int j = 1 ; j <= nums.length ; j++){
                if(i > j){
                    continue;
                }
                int maxCoins = Integer.MIN_VALUE;
                for(int k = i ; k <= j ; k++){
                    int coins = numsL.get(i-1) * numsL.get(k) * numsL.get(j+1) + dp[i][k-1] + dp[k+1][j];
                    if(coins > maxCoins){
                        maxCoins = coins;
                    }
                }

                dp[i][j] = maxCoins;
            }
        }
        return dp[1][nums.length];
    }
}