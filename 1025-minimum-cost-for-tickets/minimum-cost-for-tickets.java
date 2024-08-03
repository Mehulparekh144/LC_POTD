class Solution {
  int[] dp ;
  public int mincostTickets(int[] days, int[] costs) {
    dp = new int[366];
    Arrays.fill(dp , -1);
    return solve(0, days, costs);
  }

  private int solve(int day, int[] days, int[] costs) {

    if (day >= days.length) {
      return 0;
    }

    if(dp[day] != -1) return dp[day];

    int one = costs[0] + solve(day + 1, days, costs);

    int j = day;
    while (j < days.length && days[j] < days[day] + 7) {
      j++;
    }
    int seven = costs[1] + solve(j, days, costs);

    j = day;
    while (j < days.length && days[j] < days[day] + 30) {
      j++;
    }

    int thirty = costs[2] + solve(j, days, costs);

    return dp[day] = Math.min(one, Math.min(seven, thirty));
  }
}