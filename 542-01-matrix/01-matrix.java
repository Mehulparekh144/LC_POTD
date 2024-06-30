class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = new int[][]{
            {0,1} , {0,-1} , {1,0} , {-1,0}
        };
        int[][] res = new int[m][n];
        for(int[] row : res) Arrays.fill(row , -1);

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(mat[i][j] == 0){
                    q.offer(new int[]{i , j});
                    res[i][j] = 0;
                }
            }
        }

        while(!q.isEmpty()){
            int[] coord = q.poll();
            int i = coord[0];
            int j = coord[1];

            for(int[] dir : dirs){
                int newi = dir[0] + i;
                int newj = dir[1] + j;

                if(newi < 0 || newj < 0 || newi >= m || newj >= n || res[newi][newj] != -1){
                    continue;
                }

                res[newi][newj] = 1 + res[i][j];
                q.offer(new int[]{newi , newj});
            }
        }

        return res;
    }
}