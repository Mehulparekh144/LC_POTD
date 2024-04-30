class Pair {
    int r;
    int c;

    public Pair(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] result = new int[m][n];
        for (int[] row : result) {
            Arrays.fill(row, -1);
        }
        Queue<Pair> q = new LinkedList<>();

        int[] dirX = new int[] { -1, 0, 1, 0 };
        int[] dirY = new int[] { 0, -1, 0, 1 };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.offer(new Pair(i, j));
                    result[i][j] = 0;
                }
            }
        }

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int x = p.r;
            int y = p.c;
            int min = Integer.MAX_VALUE;
            for (int k = 0; k < 4; k++) {
                int dx = x + dirX[k];
                int dy = y + dirY[k];

                if (dx < 0 || dy < 0 || dx >= m || dy >= n || result[dx][dy] != -1) {
                    continue;
                }
                result[dx][dy] = 1 + result[x][y];
                q.offer(new Pair(dx , dy));
            }
        }

        return result;
    }
}