class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dirs = new int[][] {
                { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }
        };

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[] { i, j, 0 });
                } else if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0)
            return 0;

        int count = 0;
        int res = 0;

        while (!q.isEmpty()) {
            int[] pair = q.poll();
            int i = pair[0];
            int j = pair[1];
            int min = pair[2];

            res = Math.max(min, res);

            for (int[] dir : dirs) {
                int newi = i + dir[0];
                int newj = j + dir[1];

                if (newi < 0 || newj < 0 || newi >= m || newj >= n || grid[newi][newj] != 1) {
                    continue;
                }

                grid[newi][newj] = 2;
                q.offer(new int[] { newi, newj, min + 1 });
                count++;
            }

        }

        if (count != fresh)
            return -1;

        return res;
    }

}