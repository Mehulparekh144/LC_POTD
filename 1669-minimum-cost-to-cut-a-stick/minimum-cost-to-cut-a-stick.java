class Solution {
    int[][] dp;
    public int minCost(int n, int[] cuts) {
        List<Integer> list = new ArrayList<>();

        dp = new int[cuts.length+1][cuts.length+1];
        for(int[] row : dp) Arrays.fill(row , -1);

        for(int cut : cuts){
          list.add(cut);
        }
        Collections.sort(list);
        list.addFirst(0);
        list.addLast(n);

        return solve(1 , cuts.length , list);

    }

    private int solve(int i , int j , List<Integer> cuts){
      if(i > j ) return 0;

      if(dp[i][j] != -1) return dp[i][j];

      int cost = Integer.MAX_VALUE;

      for(int k = i ; k <= j ; k++){
        int cut = cuts.get(j+1) - cuts.get(i-1) + solve(i , k-1 , cuts) + solve(k+1 , j , cuts);
        cost = Math.min(cut , cost);
      }

      return dp[i][j] = cost;
    }
}