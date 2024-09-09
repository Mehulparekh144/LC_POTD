class Solution {
  class Pair{
    int x;
    int y;
    double dist;

    public Pair(int x , int y , double dist){
      this.x = x;
      this.y = y;
      this.dist = dist;
    }
  }
    public int[][] kClosest(int[][] points, int k) {
      PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Double.compare(a.dist , b.dist));

      for(int[] p : points){
        int x = p[0] , y = p[1];
        double dist = Math.sqrt(x*x + y*y);
        pq.offer(new Pair(x , y , dist));
      }

      int[][] res = new int[k][2];

      for(int i = 0 ; i < k && !pq.isEmpty() ; i++){
        res[i] = new int[]{pq.peek().x , pq.peek().y};
        pq.poll();
      }

      return res;


        
    }
}