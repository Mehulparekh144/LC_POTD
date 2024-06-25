class Solution {
    int[][] dp;
    public int minCost(int n, int[] cuts) {
        dp = new int[cuts.length + 1][cuts.length + 1];
        for(int[] row : dp) {
            Arrays.fill(row , -1);
        }
        List<Integer> cutsL = new ArrayList<>();
        for(int cut : cuts) cutsL.add(cut);

        Collections.sort(cutsL);
        cutsL.add(0 , 0);
        cutsL.addLast(n);

        return solve(1 , cuts.length , cutsL);
    }

    private int solve(int i , int j , List<Integer> cutsL){
        if(i > j) return 0;

        if(dp[i][j] != -1) return dp[i][j];
        
        int min = Integer.MAX_VALUE;
        for(int k = i ; k <= j ; k++){
            int cost = cutsL.get(j+1) - cutsL.get(i-1) + solve(i , k-1 , cutsL) + solve(k+1 , j , cutsL);
            min = Math.min(cost , min);
        }

        return dp[i][j] = min;
    }
    }