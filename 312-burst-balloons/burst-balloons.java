class Solution {
    int[][] dp;
    public int maxCoins(int[] nums) {
        dp = new int[nums.length + 1][nums.length + 1];
        for(int[] row : dp) Arrays.fill(row , -1);
        List<Integer> list = new ArrayList<>();

        for(int num : nums) {
            list.add(num);
        }

        list.addFirst(1);
        list.addLast(1);

        return solve(1 , nums.length , list);
    }

    private int solve(int i , int j , List<Integer> list){
        if(i > j) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int max = Integer.MIN_VALUE;
        for(int k = i ; k <= j ; k++){
            int coins = list.get(i-1) * list.get(k) * list.get(j+1) + solve(i , k-1 , list) + solve(k+1 , j , list);
            max = Math.max(coins , max);
        }

        return dp[i][j] = max;
    }
}