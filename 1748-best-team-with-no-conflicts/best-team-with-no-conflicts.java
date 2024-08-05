class Solution {

  public int bestTeamScore(int[] scores, int[] ages) {
    int n = scores.length;
    int[][] arr = new int[n][2];
    for (int i = 0; i < n; i++) {
      arr[i] = new int[] { scores[i], ages[i] };
    }

    Arrays.sort(arr, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

    int[] dp = new int[arr.length + 1];
    int max = 0;

    for (int i = 0; i < n; i++) {
      dp[i] = arr[i][0];

      for (int j = 0; j < i; j++) {
        if (arr[i][1] >= arr[j][1] && arr[i][0] >= arr[j][0]) {
          dp[i] = Math.max(dp[i], dp[j] + arr[i][0]);
        }

      }
      max = Math.max(max, dp[i]);

    }

    return max;

  }

}