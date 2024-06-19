class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        int prev1 = cost[cost.length - 1];
        int prev2 = cost[cost.length - 2];
        int curr = 0;
        for(int j = cost.length - 3 ; j >= 0   ; j--){
            int cost1 = cost[j] + prev1;
            int cost2 = cost[j] + prev2;
            curr = Math.min(cost1 , cost2);
            prev1 = prev2;
            prev2 = curr;
        }
        return Math.min(prev1 , prev2);
    }
}