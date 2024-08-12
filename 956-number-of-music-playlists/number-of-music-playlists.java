
class Solution {
    private static final int MOD = (int) 1e9 + 7;
    private long[][] dp;

    public int numMusicPlaylists(int n, int goal, int k) {
        dp = new long[goal + 1][n + 1];
        for (long[] row : dp) Arrays.fill(row, -1);
        return (int) (solve(n, goal, 0, k) % MOD);
    }

    private long solve(int n, int goal, int oldSongs, int k) {
        if (goal == 0) {
            return oldSongs == n ? 1 : 0;
        }

        if (oldSongs > n) {
            return 0;
        }

        if (dp[goal][oldSongs] != -1) {
            return dp[goal][oldSongs];
        }

        // Choose new song
        long res = (n - oldSongs) * solve(n, goal - 1, oldSongs + 1, k) % MOD;

        // Choose old song
        if (oldSongs > k) {
            res = (res + (oldSongs - k) * solve(n, goal - 1, oldSongs, k) % MOD) % MOD;
        }

        dp[goal][oldSongs] = res;
        return res;
    }
}
