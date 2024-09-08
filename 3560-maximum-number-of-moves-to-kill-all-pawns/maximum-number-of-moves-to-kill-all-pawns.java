class Solution {
   private final static int[][] DIRS = {
      { -2, 1 }, { -2, -1 }, { 2, 1 }, { 2, -1 },
      { -1, 2 }, { -1, -2 }, { 1, 2 }, { 1, -2 }
  };

  int[][] dp;

  public int maxMoves(int kx, int ky, int[][] positions) {
    int n = positions.length;
    // 1. Calculate minimum steps from kx,ky to all pawn position
    List<int[]> pos = new ArrayList<>();
    Collections.addAll(pos, positions);

    pos.addFirst(new int[] { kx, ky });
    int[][] minDist = new int[pos.size()][pos.size()];
    for (int i = 0; i < pos.size(); i++) {
      bfs(pos.get(i)[0], pos.get(i)[1], i, minDist, pos);
    }

    // 2. Solve recursively using bitmasking and the minDist array given
    // 0th idx has knight
    // 1<<n-1 represents the mask of n size;
    dp = new int[51][1 << 15]; // 15 in the constraints
    for(int[] row : dp) Arrays.fill(row , -1);
    return solve(minDist , 0 , true , (1<<n )- 1 , pos);
  }

  private int solve(int[][] minDist , int idx , boolean isAlice , int mask , List<int[]> pos){
    if(mask == 0) return 0;

    if(dp[idx][mask] != -1) return dp[idx][mask];

    // Alice maximize and bob minimize
    int res = isAlice ? -1 : (int) 1e9;

    for(int i = 1 ; i < pos.size() ; i++ ){
      // 1 1 1
      // i = 1, at mask pos will be i - 1 which is 0
      // 1 1 1
      //&    1

      if((mask & (1 << ( i - 1))) != 0){
        // Pawn is set so available
        int moves = minDist[idx][i];

        if(isAlice){
          res = Math.max(
              res,
              moves +
              solve(minDist , i , false, mask^(1 << (i-1))  , pos)
          );
        } else{
          res = Math.min(
              res,
              moves +
              solve(minDist , i , true, mask^(1 << (i-1))  , pos)
          );
        }
      }
    }

    return dp[idx][mask] = res;
  }

  private void bfs(int i, int j, int idx, int[][] minDist, List<int[]> pos) {
    int[][] dis = new int[50][50];
    for (int[] r : dis) {
      Arrays.fill(r, -1);
    }
    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[] { i, j });

    dis[i][j] = 0;

    while (!q.isEmpty()) {
      int[] p = q.poll();
      int ci = p[0], cj = p[1];

      for (int[] dir : DIRS) {
        int newi = ci + dir[0];
        int newj = cj + dir[1];

        if (newi >= 0 && newj >= 0 && newi < 50 && newj < 50 && dis[newi][newj] == -1) {
          dis[newi][newj] = dis[ci][cj] + 1;
          q.offer(new int[] { newi, newj });
        }
      }

    }

    // minDist[idx][k] Represents cell starting from idx 0 i.e. kx, ky to all other
    // pawns positions
    for (int k = 0; k < pos.size(); k++) {
      minDist[idx][k] = dis[pos.get(k)[0]][pos.get(k)[1]];
    }

  }
}