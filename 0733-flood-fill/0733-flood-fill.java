class Pair{
    int row;
    int col;
    public Pair(int row , int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int[][] visited = image;
        int src = image[sr][sc];
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(sr , sc));
        visited[sr][sc] = color;
        int[] dirX = new int[]{-1,0,1,0};
        int[] dirY = new int[]{0 , 1 , 0 , -1};

        while(!q.isEmpty()){
            Pair p = q.poll();
            int r = p.row;
            int c = p.col;

            for(int i = 0 ; i < 4 ; i++){
                int dr = r + dirX[i];
                int dc = c + dirY[i];

                if(dr < 0 || dc < 0 || dr >= m || dc >= n || image[dr][dc] == color || image[dr][dc] != src){
                continue;
                }

                if(visited[dr][dc] != color){
                    visited[dr][dc] = color;
                    q.offer(new Pair(dr , dc));
                }
            }

        }

        return visited; 
    }
}