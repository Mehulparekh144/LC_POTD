class Solution {
  public int mincostTickets(int[] days, int[] costs) {
    int[] dp = new int[366];
    int n = days.length;

    for(int i = n-1 ; i >= 0 ; i--){
      int one = costs[0] + dp[i + 1];
      int j = i;

      while(j < n && days[j] < days[i]+7){
        j++;
      }

      int seven = costs[1] + dp[j];

      j = i;
            while(j < n && days[j] < days[i]+30){
        j++;
      }

      int thirty = costs[2] + dp[j];

      dp[i] = Math.min(one, Math.min(seven, thirty));
    }

    return dp[0];
  }

}