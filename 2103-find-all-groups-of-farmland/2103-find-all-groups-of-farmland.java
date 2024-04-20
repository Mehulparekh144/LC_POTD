class Solution {
    private void dfs(int i , int j , int[][] land , int[] path){
        int m  = land.length;
        int n = land[0].length;
        if(i < 0 || j < 0 || i>= m || j >= n || land[i][j] == 0 ){
            return;
        }
        path[2] = Math.max(path[2] , i);
        path[3] = Math.max(path[3] , j);
        land[i][j] = 0;
        dfs(i+1 , j , land , path);
        dfs(i-1 , j , land , path);
        dfs(i , j-1 , land , path);
        dfs(i , j+1 , land , path);
    }

    public int[][] findFarmland(int[][] land) {
        int m = land.length;
        int n = land[0].length;
        List<int[]> ans = new ArrayList<>();

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(land[i][j] == 1){
                    int[] path = new int[4];
                    path[0] = i;
                    path[1] = j;
                    dfs(i , j , land ,path);
                    ans.add(path);
                }
            }
        }
        return ans.stream().toArray(int[][]::new);
    }
}