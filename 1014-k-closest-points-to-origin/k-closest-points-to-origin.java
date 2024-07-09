class Solution {

    class Pair{
      int[] point;
      double dist;

      public Pair(int[] point , double dist){
        this.point = point;
        this.dist = dist;
      }
    }

    public int[][] kClosest(int[][] points, int k) {
      int[][] res = new int[k][2];
      PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Double.compare(a.dist, b.dist));

      for(int[] point : points){
        int x = point[0];
        int y = point[1];

        double dis =  Math.sqrt(x*x + y*y);
        pq.offer(new Pair(point , dis));
      }   

      for(int i = 0 ; i < k && !pq.isEmpty() ; i++){
        Pair p = pq.poll();
        res[i] = p.point;
      }

      return res;
    }
}