class Solution {
    public long maxPoints(int[][] points) {
    int m = points.length;
    int n = points[0].length;

    long[] row = new long[n];
    for (int i = 0; i < n; i++) {
        row[i] = points[0][i];
    }

    for (int r = 1; r < m; r++) {
        long[] nextRow = new long[n];
        long[] left = new long[n];
        long[] right = new long[n];

        left[0] = row[0];
        for (int c = 1; c < n; c++) {
            left[c] = Math.max(row[c], left[c - 1] - 1);
        }

        right[n - 1] = row[n - 1];
        for (int c = n - 2; c >= 0; c--) {
            right[c] = Math.max(row[c], right[c + 1] - 1);
        }

        for (int c = 0; c < n; c++) {
            nextRow[c] = points[r][c] + Math.max(left[c], right[c]);
        }

        row = nextRow; 
    }

    return Arrays.stream(row).max().getAsLong();
}


}