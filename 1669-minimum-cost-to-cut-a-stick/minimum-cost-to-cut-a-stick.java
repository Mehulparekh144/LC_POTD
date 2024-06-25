class Solution {
    int[][] dp;

    public int minCost(int n, int[] cuts) {
        dp = new int[cuts.length + 2][cuts.length + 2];
        List<Integer> cutsL = new ArrayList<>();
        for (int cut : cuts)
            cutsL.add(cut);

        Collections.sort(cutsL);
        cutsL.add(0, 0);
        cutsL.addLast(n);

        for (int i = cuts.length; i >= 1; i--) {
            for (int j = 1; j <= cuts.length; j++) {
                if (i > j) {
                    continue;
                }

                int min = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    int cost = cutsL.get(j + 1) - cutsL.get(i - 1) + dp[i][k-1] + dp[k+1][j];
                    min = Math.min(cost, min);
                }

                dp[i][j] = min;
            }
        }

        return dp[1][cuts.length];
    }
}