class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] colored = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (colored[i] == 0 && !dfs(i , colored , graph , 1)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int i , int[] colored , int[][] graph , int color){
        colored[i] = color;

        for(int child : graph[i]){
            if(colored[child] == 0 && !dfs(child , colored , graph , -color)){
                return false;
            }
            else if(colored[child] == color){
                return false;
            }
        }

        return true;
    }

}