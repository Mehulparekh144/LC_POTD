class Solution {

    public int[][] findFarmland(int[][] land) {
        int m = land.length;
        int n = land[0].length;
        List<int[]> ans = new ArrayList<>();

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(land[i][j] == 0) continue;

                int j1 = j;
                while(j1 < n  && land[i][j1] == 1){
                    j1++;
                }

                int i1 = i;
                while(i1 < m && land[i1][j] == 1){
                    i1++;
                }

                j1 = j1 == 0 ? j1 : j1-1;
                i1 = i1 == 0 ? i1 : i1-1;

                ans.add(new int[]{i , j , i1 , j1});

                for(int row = i ; row <= i1 ; row++){
                    for(int col = j ; col <= j1 ; col++){
                        land[row][col] = 0;
                    }
                }
            }
        }
        return ans.stream().toArray(int[][]::new);
    }
}