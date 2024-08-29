class Solution {
    public int findJudge(int n, int[][] trust) {
        // Judge
        // No outgoing edge
        // And incoming edge

        int[] outdegree = new int[n + 1];
        int[] indegree = new int[n+1];
        
        for(int[] t : trust){
          int u = t[0] , v = t[1];
          outdegree[u]++;
          indegree[v]++;
        }

        int ans = -1;
        for(int i = 1 ; i <= n ; i++){
          if(outdegree[i] == 0 && indegree[i] == n-1){
            ans = i;
            break;
          }
        }

        return ans;
    }
}