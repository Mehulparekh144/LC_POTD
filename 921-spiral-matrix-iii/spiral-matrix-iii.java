class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        List<int[]> res = new ArrayList<>();
        int r = rStart;
        int c = cStart;

        int[][] dirs = {
          {0,1} , {1,0} , {0,-1} , {-1,0}
        };

        int steps = 1;
        int i = 0;
        while(res.size() < rows*cols){

          for(int x = 0 ; x < 2 ; x++){
            int dr = dirs[i][0];
            int dc = dirs[i][1];

            for(int y = 0 ; y < steps ; y++){
              if(r >= 0 && r < rows && c >= 0 && c < cols){
                res.add(new int[]{r,c});
              }

              r += dr;
              c += dc;
            } 

            i = (i+1)%4;
          }
          steps++;
        }

        int[][] ans = new int[res.size()][2];
        int idx = 0;
        for(int[] row : res){
          ans[idx++] = row;
        }

        return ans;
    }
}